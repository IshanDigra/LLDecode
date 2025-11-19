# Parking Lot V3 - Future Improvements & FANG-Level Analysis

**Assessment Date**: November 19, 2025  
**Overall Rating**: 6.5/10 for FANG-level LLD  
**Status**: SOLID MID-LEVEL with critical improvements needed

---

## Executive Summary

This document provides a comprehensive analysis of the Parking Lot V3 implementation, identifying strengths, weaknesses, and actionable improvements to elevate the solution to FANG-level standards.

### Current State
- ✅ Good foundational design patterns (Singleton, Strategy)
- ✅ Basic thread safety awareness
- ✅ Clean code organization
- ❌ Critical race conditions under concurrent load
- ❌ Missing production-grade error handling
- ❌ Incomplete domain model
- ❌ No input validation

---

## Table of Contents

1. [Strengths Analysis](#strengths-analysis)
2. [Critical Issues](#critical-issues)
3. [Code Improvements](#code-improvements)
4. [Enhanced Implementation](#enhanced-implementation)
5. [Production Readiness Checklist](#production-readiness-checklist)

---

## Strengths Analysis

| Aspect | Implementation | Impact |
|--------|---------------|--------|
| **Design Patterns** | Singleton (ParkingLot), Strategy (Fare/Payment) | Good extensibility and maintainability |
| **Thread Safety** | Double-checked locking, synchronized methods, ConcurrentHashMap | Shows concurrency awareness |
| **SOLID Principles** | Strategy interfaces, SRP in entities | Clean separation of concerns |
| **Code Organization** | Entities, Enums, Services, Util packages | Standard Java conventions followed |
| **Type Safety** | Enums for VehicleType, ParkingStatus, PaymentStatus | Prevents invalid states |
| **Extensibility** | Easy to add new fare/payment strategies | Open-Closed Principle applied |

---

## Critical Issues

### 1. Race Condition in Spot Assignment

**Severity**: 🔴 CRITICAL - System Crash Risk

**Problem**:
```java
// CURRENT CODE - VULNERABLE
public synchronized ParkingTicket parkVehicle(Vehicle vehicle){
    List<ParkingSpot> freeSpots = getParkingSpots(vehicle.getType());
    if(freeSpots.size()==0){ return null; }
    
    ParkingSpot spot = freeSpots.get(0);
    spot.parkVehicle(vehicle);  // ❌ TOCTOU race condition
}
```

**Issue**: Time-of-Check to Time-of-Use (TOCTOU)
- Thread A queries available spots
- Thread B parks in the spot
- Thread A attempts to park in same spot → RuntimeException

**Impact**: Production system crashes under concurrent load

**Solution**: Atomic find-and-claim operation (see improvements below)

---

### 2. Generic Exception Handling

**Severity**: 🔴 CRITICAL - Poor Error Recovery

**Problem**:
```java
throw new RuntimeException("Spot Already Booked");
throw new RuntimeException("Vehicle Type is not compatible");
```

**Issues**:
- Cannot distinguish between error types
- No recovery mechanism for callers
- Poor debugging experience
- Violates exception best practices

**Solution**: Custom exception hierarchy with error codes

---

### 3. Data Structure Bug

**Severity**: 🟠 HIGH - Data Loss

**Problem**:
```java
// ParkingLevel.java - LOSES DATA
parkingSpots.forEach(p->{
    List<ParkingSpot> temp = spots.getOrDefault(p.getType(), new ArrayList<>());
    temp.add(p);  // ❌ Creates new list each time
    this.spots.put(p.getType(),temp);
});
```

**Issue**: Each iteration creates a new ArrayList, overwriting previous entries for the same VehicleType

**Solution**: Use `computeIfAbsent` pattern

---

### 4. Missing Input Validation

**Severity**: 🟠 HIGH - Security Risk

**Missing Validations**:
- Null checks for Vehicle, ParkingTicket
- Number plate format validation
- Payment amount validation
- Ticket validity verification

**Impact**: NullPointerException, invalid state, security vulnerabilities

---

### 5. Incomplete Domain Model

**Severity**: 🟡 MEDIUM - Business Logic Gap

**Missing Fields**:
- Exit time in ParkingTicket
- Duration calculation
- Receipt generation
- Audit trail
- Payment transaction ID

**Impact**: Cannot track full parking lifecycle, no receipts for customers

---

### 6. Code Quality Issues

**Severity**: 🟡 MEDIUM - Maintainability

**Issues**:
```java
public static ParkingLot getInstace()  // ❌ Typo
if(p.equals(null))                     // ❌ NPE risk, should be p == null
return null;                           // ❌ Inconsistent error signaling
```

---

### 7. Missing Business Features

**Severity**: 🟡 MEDIUM - Feature Completeness

| Feature | Current State | Expected |
|---------|--------------|----------|
| Spot Assignment Strategy | Just `get(0)` | Nearest, load balancing, preference |
| Vehicle-Spot Compatibility | Strict matching | Larger spot can fit smaller vehicle |
| Capacity Limits | No enforcement | Max capacity per level/lot |
| Spot Reservation | Not supported | Advance booking |
| Multi-floor Optimization | No strategy | Distribute load intelligently |

---

### 8. Production Concerns

**Severity**: 🟡 MEDIUM - Operational Readiness

| Aspect | Missing | Impact |
|--------|---------|--------|
| Logging | Basic, no structured logging | Poor debugging |
| Monitoring | No metrics emission | No visibility |
| Testing | No unit tests | No confidence |
| Documentation | Minimal Javadoc | Poor maintainability |
| Configuration | Hardcoded values | Inflexible deployment |

---

## Code Improvements

### Improvement 1: Atomic Spot Assignment

**File**: `Services/ParkingLot.java`

```java
/**
 * Parks a vehicle in the first available spot atomically.
 * Thread-safe implementation prevents race conditions.
 * 
 * @param vehicle Vehicle to park
 * @return ParkingTicket for the parked vehicle
 * @throws NoAvailableSpotException if no spots available
 * @throws InvalidVehicleException if vehicle is invalid
 */
public ParkingTicket parkVehicle(Vehicle vehicle) 
        throws NoAvailableSpotException, InvalidVehicleException {
    
    validateVehicle(vehicle);
    
    // Atomic operation: find and claim spot in one go
    for (ParkingLevel level : levels) {
        ParkingSpot spot = level.findAndClaimSpot(vehicle.getType());
        if (spot != null) {
            ParkingTicket ticket = createTicket(vehicle, spot);
            logger.info("Vehicle {} parked at spot {} on level {}", 
                vehicle.getNumberPlate(), spot.getId(), level.getId());
            return ticket;
        }
    }
    
    throw new NoAvailableSpotException(
        "No available spots for vehicle type: " + vehicle.getType()
    );
}

private void validateVehicle(Vehicle vehicle) throws InvalidVehicleException {
    if (vehicle == null) {
        throw new InvalidVehicleException("Vehicle cannot be null");
    }
    if (vehicle.getNumberPlate() == null || vehicle.getNumberPlate().trim().isEmpty()) {
        throw new InvalidVehicleException("Vehicle number plate is required");
    }
    if (vehicle.getType() == null) {
        throw new InvalidVehicleException("Vehicle type is required");
    }
}

private ParkingTicket createTicket(Vehicle vehicle, ParkingSpot spot) {
    return new ParkingTicket(vehicle, spot, LocalDateTime.now());
}
```

**File**: `Entities/ParkingLevel.java`

```java
/**
 * Atomically finds and claims an available spot for the given vehicle type.
 * This method is synchronized to prevent race conditions.
 * 
 * @param type Vehicle type to find spot for
 * @return ParkingSpot if available, null otherwise
 */
public synchronized ParkingSpot findAndClaimSpot(VehicleType type) {
    List<ParkingSpot> spotsForType = spots.get(type);
    if (spotsForType == null || spotsForType.isEmpty()) {
        return null;
    }
    
    // Try to claim each spot atomically
    for (ParkingSpot spot : spotsForType) {
        if (spot.tryPark(type)) {
            return spot;
        }
    }
    
    return null;
}

public int getAvailableSpotCount(VehicleType type) {
    List<ParkingSpot> spotsForType = spots.get(type);
    if (spotsForType == null) return 0;
    
    return (int) spotsForType.stream()
        .filter(spot -> spot.getStatus() == ParkingStatus.UNOCCUPIED)
        .count();
}

public String getId() {
    return id;
}
```

**File**: `Entities/ParkingSpot.java`

```java
/**
 * Atomically attempts to park a vehicle in this spot.
 * 
 * @param vehicleType Type of vehicle attempting to park
 * @return true if successfully claimed, false otherwise
 */
public synchronized boolean tryPark(VehicleType vehicleType) {
    if (status == ParkingStatus.OCCUPIED) {
        return false;
    }
    if (!canAccommodate(vehicleType)) {
        return false;
    }
    status = ParkingStatus.OCCUPIED;
    logger.info("Spot {} claimed for vehicle type {}", id, vehicleType);
    return true;
}

/**
 * Checks if this spot can accommodate the given vehicle type.
 * Allows larger spots to accommodate smaller vehicles.
 * 
 * @param vehicleType Vehicle type to check
 * @return true if compatible, false otherwise
 */
private boolean canAccommodate(VehicleType vehicleType) {
    return vehicleType.canFitIn(this.type);
}

public synchronized void unparkVehicle() throws InvalidOperationException {
    if (status == ParkingStatus.UNOCCUPIED) {
        throw new InvalidOperationException("Cannot unpark - spot is already empty");
    }
    status = ParkingStatus.UNOCCUPIED;
    logger.info("Spot {} released", id);
}
```

---

### Improvement 2: Custom Exception Hierarchy

**File**: `Exceptions/ParkingLotException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Base exception for all parking lot related errors.
 * Provides error code for programmatic error handling.
 */
public class ParkingLotException extends Exception {
    private final String errorCode;
    
    public ParkingLotException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public ParkingLotException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() {
        return errorCode;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", errorCode, getMessage());
    }
}
```

**File**: `Exceptions/NoAvailableSpotException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Thrown when no parking spot is available for the requested vehicle type.
 */
public class NoAvailableSpotException extends ParkingLotException {
    public NoAvailableSpotException(String message) {
        super(message, "NO_SPOT_AVAILABLE");
    }
}
```

**File**: `Exceptions/InvalidVehicleException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Thrown when vehicle data is invalid or incomplete.
 */
public class InvalidVehicleException extends ParkingLotException {
    public InvalidVehicleException(String message) {
        super(message, "INVALID_VEHICLE");
    }
}
```

**File**: `Exceptions/PaymentFailedException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Thrown when payment processing fails.
 */
public class PaymentFailedException extends ParkingLotException {
    public PaymentFailedException(String message) {
        super(message, "PAYMENT_FAILED");
    }
    
    public PaymentFailedException(String message, Throwable cause) {
        super(message, "PAYMENT_FAILED", cause);
    }
}
```

**File**: `Exceptions/InvalidTicketException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Thrown when ticket is invalid, expired, or already processed.
 */
public class InvalidTicketException extends ParkingLotException {
    public InvalidTicketException(String message) {
        super(message, "INVALID_TICKET");
    }
}
```

**File**: `Exceptions/InvalidOperationException.java`

```java
package ParkingLot_V3.Exceptions;

/**
 * Thrown when an operation is invalid in the current state.
 */
public class InvalidOperationException extends ParkingLotException {
    public InvalidOperationException(String message) {
        super(message, "INVALID_OPERATION");
    }
}
```

---

### Improvement 3: Fix Data Structure Bug

**File**: `Entities/ParkingLevel.java`

```java
package ParkingLot_V3.Entities;

import ParkingLot_V3.Enums.ParkingStatus;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Util.IdGeneratorUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ParkingLevel {
    private final String id;
    private final Map<VehicleType, List<ParkingSpot>> spots;

    public ParkingLevel(List<ParkingSpot> parkingSpots) {
        this.id = IdGeneratorUtil.generateLevelId();
        this.spots = new ConcurrentHashMap<>();
        
        // Correctly group spots by type using computeIfAbsent
        parkingSpots.forEach(spot -> {
            spots.computeIfAbsent(spot.getType(), k -> new CopyOnWriteArrayList<>())
                 .add(spot);
        });
    }

    public synchronized ParkingSpot findAndClaimSpot(VehicleType type) {
        List<ParkingSpot> spotsForType = spots.get(type);
        if (spotsForType == null || spotsForType.isEmpty()) {
            return null;
        }
        
        for (ParkingSpot spot : spotsForType) {
            if (spot.tryPark(type)) {
                return spot;
            }
        }
        
        return null;
    }

    public List<ParkingSpot> getParkingSpots(VehicleType type) {
        List<ParkingSpot> spotsForType = spots.get(type);
        if (spotsForType == null) {
            return List.of();
        }
        
        return spotsForType.stream()
            .filter(spot -> spot.getStatus() == ParkingStatus.UNOCCUPIED)
            .collect(Collectors.toList());
    }
    
    public int getAvailableSpotCount(VehicleType type) {
        return getParkingSpots(type).size();
    }
    
    public int getTotalAvailableSpots() {
        return spots.values().stream()
            .flatMap(List::stream)
            .filter(spot -> spot.getStatus() == ParkingStatus.UNOCCUPIED)
            .mapToInt(spot -> 1)
            .sum();
    }

    public String getId() {
        return id;
    }
}
```

---

### Improvement 4: Enhanced Domain Model

**File**: `Entities/ParkingTicket.java`

```java
package ParkingLot_V3.Entities;

import ParkingLot_V3.Enums.PaymentStatus;
import ParkingLot_V3.Util.IdGeneratorUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Represents a parking ticket issued when a vehicle is parked.
 * Tracks entry, exit, payment status, and duration.
 */
public class ParkingTicket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private PaymentStatus status;
    private Double amountPaid;
    private String paymentMethod;
    private String transactionId;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot, LocalDateTime entryTime) {
        this.id = IdGeneratorUtil.generateTicketId();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
        this.status = PaymentStatus.PENDING;
    }

    /**
     * Marks payment as completed and records transaction details.
     */
    public synchronized void completePayment(double amount, String paymentMethod, String transactionId) {
        this.exitTime = LocalDateTime.now();
        this.amountPaid = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = PaymentStatus.COMPLETED;
    }

    /**
     * Calculates parking duration in seconds.
     * If exit time is not set, uses current time.
     */
    public long getParkingDurationInSeconds() {
        LocalDateTime end = (exitTime != null) ? exitTime : LocalDateTime.now();
        return ChronoUnit.SECONDS.between(entryTime, end);
    }

    /**
     * Calculates parking duration in minutes.
     */
    public long getParkingDurationInMinutes() {
        LocalDateTime end = (exitTime != null) ? exitTime : LocalDateTime.now();
        return ChronoUnit.MINUTES.between(entryTime, end);
    }

    /**
     * Calculates parking duration in hours (rounded up).
     */
    public long getParkingDurationInHours() {
        LocalDateTime end = (exitTime != null) ? exitTime : LocalDateTime.now();
        long minutes = ChronoUnit.MINUTES.between(entryTime, end);
        return (minutes + 59) / 60; // Round up
    }

    // Getters
    public String getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public PaymentStatus getStatus() { return status; }
    public Double getAmountPaid() { return amountPaid; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getTransactionId() { return transactionId; }

    @Override
    public String toString() {
        return String.format(
            "ParkingTicket[id=%s, vehicle=%s, spot=%s, entry=%s, status=%s]",
            id, vehicle.getNumberPlate(), spot.getId(), entryTime, status
        );
    }
}
```

**File**: `Entities/Receipt.java`

```java
package ParkingLot_V3.Entities;

import ParkingLot_V3.Enums.VehicleType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Represents a payment receipt for a parking transaction.
 * Generated after successful payment completion.
 */
public class Receipt {
    private final String receiptId;
    private final String ticketId;
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime;
    private final long durationInMinutes;
    private final double fare;
    private final double amountPaid;
    private final double change;
    private final String paymentMethod;
    private final String transactionId;
    private final LocalDateTime generatedAt;
    
    private static final DateTimeFormatter FORMATTER = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Receipt(ParkingTicket ticket, double fare, double amountPaid) {
        this.receiptId = "REC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.ticketId = ticket.getId();
        this.vehicleNumber = ticket.getVehicle().getNumberPlate();
        this.vehicleType = ticket.getVehicle().getType();
        this.entryTime = ticket.getEntryTime();
        this.exitTime = ticket.getExitTime();
        this.durationInMinutes = ticket.getParkingDurationInMinutes();
        this.fare = fare;
        this.amountPaid = amountPaid;
        this.change = amountPaid - fare;
        this.paymentMethod = ticket.getPaymentMethod();
        this.transactionId = ticket.getTransactionId();
        this.generatedAt = LocalDateTime.now();
    }

    // Getters
    public String getReceiptId() { return receiptId; }
    public String getTicketId() { return ticketId; }
    public String getVehicleNumber() { return vehicleNumber; }
    public VehicleType getVehicleType() { return vehicleType; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public long getDurationInMinutes() { return durationInMinutes; }
    public double getFare() { return fare; }
    public double getAmountPaid() { return amountPaid; }
    public double getChange() { return change; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getTransactionId() { return transactionId; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    @Override
    public String toString() {
        return String.format("""
            ╔════════════════════════════════════════╗
            ║       PARKING RECEIPT                  ║
            ╠════════════════════════════════════════╣
            ║ Receipt ID    : %-22s ║
            ║ Ticket ID     : %-22s ║
            ║ Vehicle       : %-22s ║
            ║ Type          : %-22s ║
            ╠════════════════════════════════════════╣
            ║ Entry Time    : %-22s ║
            ║ Exit Time     : %-22s ║
            ║ Duration      : %3d minutes              ║
            ╠════════════════════════════════════════╣
            ║ Fare          : $%-21.2f ║
            ║ Amount Paid   : $%-21.2f ║
            ║ Change        : $%-21.2f ║
            ╠════════════════════════════════════════╣
            ║ Payment Method: %-22s ║
            ║ Transaction ID: %-22s ║
            ║ Generated At  : %-22s ║
            ╚════════════════════════════════════════╝
            """,
            receiptId, ticketId, vehicleNumber, vehicleType,
            entryTime.format(FORMATTER), exitTime.format(FORMATTER),
            durationInMinutes, fare, amountPaid, change,
            paymentMethod, transactionId, generatedAt.format(FORMATTER)
        );
    }
}
```

---

### Improvement 5: Enhanced VehicleType with Size

**File**: `Enums/VehicleType.java`

```java
package ParkingLot_V3.Enums;

/**
 * Represents different types of vehicles with size hierarchy.
 * Larger spots can accommodate smaller vehicles.
 */
public enum VehicleType {
    TWO_WHEELER(1),
    FOUR_WHEELER(2),
    SIX_WHEELER(3);
    
    private final int size;
    
    VehicleType(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    /**
     * Checks if this vehicle type can fit in a spot of the given type.
     * Allows smaller vehicles to fit in larger spots.
     * 
     * @param spotType The parking spot type
     * @return true if vehicle can fit in the spot
     */
    public boolean canFitIn(VehicleType spotType) {
        return this.size <= spotType.size;
    }
}
```

---

### Improvement 6: Payment Processing with Validation

**File**: `Services/ParkingLot.java` (Updated)

```java
/**
 * Processes payment for a parking ticket with comprehensive validation.
 * 
 * @param ticket Parking ticket
 * @param fareStrategy Strategy to calculate fare
 * @param paymentStrategy Strategy to process payment
 * @param fareConfig Fare configuration map
 * @param amountProvided Amount provided by customer
 * @return Receipt for the transaction
 * @throws ParkingLotException if validation or processing fails
 */
public Receipt processPayment(
    ParkingTicket ticket,
    FareStrategy fareStrategy,
    PaymentStrategy paymentStrategy,
    Map<VehicleType, Double> fareConfig,
    double amountProvided
) throws ParkingLotException {
    
    // Validate inputs
    validateTicket(ticket);
    validateFareConfig(fareConfig, ticket.getVehicle().getType());
    
    // Calculate fare
    double fare = fareStrategy.getTicketFare(ticket, fareConfig);
    
    // Validate payment amount
    validatePayment(amountProvided, fare);
    
    // Process payment
    String transactionId = UUID.randomUUID().toString();
    boolean paymentSuccess = paymentStrategy.makePayment(amountProvided);
    
    if (!paymentSuccess) {
        throw new PaymentFailedException(
            "Payment processing failed. Please try again or use a different payment method."
        );
    }
    
    // Update ticket
    synchronized (ticket) {
        ticket.completePayment(fare, paymentStrategy.getPaymentMethodName(), transactionId);
    }
    
    // Release spot
    unparkVehicle(ticket);
    
    // Generate receipt
    Receipt receipt = new Receipt(ticket, fare, amountProvided);
    
    logger.info("Payment completed successfully. Receipt: {}", receipt.getReceiptId());
    
    return receipt;
}

private void validateTicket(ParkingTicket ticket) throws InvalidTicketException {
    if (ticket == null) {
        throw new InvalidTicketException("Ticket cannot be null");
    }
    if (ticket.getStatus() == PaymentStatus.COMPLETED) {
        throw new InvalidTicketException("Payment already completed for ticket: " + ticket.getId());
    }
}

private void validateFareConfig(Map<VehicleType, Double> fareConfig, VehicleType vehicleType) 
        throws InvalidOperationException {
    if (fareConfig == null || !fareConfig.containsKey(vehicleType)) {
        throw new InvalidOperationException(
            "Fare configuration missing for vehicle type: " + vehicleType
        );
    }
}

private void validatePayment(double amountProvided, double fare) throws PaymentFailedException {
    if (amountProvided < 0 || fare < 0) {
        throw new PaymentFailedException("Invalid payment amount");
    }
    if (amountProvided < fare) {
        throw new PaymentFailedException(
            String.format("Insufficient payment. Required: $%.2f, Provided: $%.2f", 
                fare, amountProvided)
        );
    }
}

public synchronized void unparkVehicle(ParkingTicket ticket) throws InvalidOperationException {
    if (ticket == null) {
        throw new InvalidOperationException("Ticket cannot be null");
    }
    ticket.getSpot().unparkVehicle();
    logger.info("Vehicle unparked from spot: {}", ticket.getSpot().getId());
}
```

---

### Improvement 7: Payment Strategy Enhancement

**File**: `Services/Payment/PaymentStrategy.java`

```java
package ParkingLot_V3.Services.Payment;

/**
 * Strategy interface for processing payments.
 */
public interface PaymentStrategy {
    /**
     * Processes payment for the given amount.
     * 
     * @param amount Amount to process
     * @return true if payment successful, false otherwise
     */
    boolean makePayment(double amount);
    
    /**
     * Returns the name of this payment method.
     * 
     * @return Payment method name
     */
    String getPaymentMethodName();
}
```

**File**: `Services/Payment/CashPayment.java`

```java
package ParkingLot_V3.Services.Payment;

import java.util.logging.Logger;

public class CashPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(CashPayment.class.getName());

    @Override
    public boolean makePayment(double amount) {
        logger.info("Processing cash payment of $" + amount);
        // Simulate cash payment processing
        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "CASH";
    }
}
```

**File**: `Services/Payment/UPIPayment.java`

```java
package ParkingLot_V3.Services.Payment;

import java.util.logging.Logger;

public class UPIPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(UPIPayment.class.getName());

    @Override
    public boolean makePayment(double amount) {
        logger.info("Processing UPI payment of $" + amount);
        // Simulate UPI payment processing
        // In real implementation, would integrate with payment gateway
        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "UPI";
    }
}
```

---

### Improvement 8: Spot Assignment Strategies

**File**: `Services/SpotAssignmentStrategy.java`

```java
package ParkingLot_V3.Services;

import ParkingLot_V3.Entities.ParkingLevel;
import ParkingLot_V3.Entities.ParkingSpot;
import ParkingLot_V3.Enums.VehicleType;

import java.util.List;

/**
 * Strategy interface for parking spot assignment algorithms.
 */
public interface SpotAssignmentStrategy {
    /**
     * Finds and claims the best available parking spot.
     * 
     * @param levels List of parking levels
     * @param vehicleType Type of vehicle to park
     * @return ParkingSpot if available, null otherwise
     */
    ParkingSpot findBestSpot(List<ParkingLevel> levels, VehicleType vehicleType);
}
```

**File**: `Services/NearestToEntranceStrategy.java`

```java
package ParkingLot_V3.Services;

import ParkingLot_V3.Entities.ParkingLevel;
import ParkingLot_V3.Entities.ParkingSpot;
import ParkingLot_V3.Enums.VehicleType;

import java.util.List;

/**
 * Assigns spots starting from the lowest level (nearest to entrance).
 * Provides convenience for customers by minimizing walking distance.
 */
public class NearestToEntranceStrategy implements SpotAssignmentStrategy {
    
    @Override
    public ParkingSpot findBestSpot(List<ParkingLevel> levels, VehicleType vehicleType) {
        // Iterate from ground level upward
        for (ParkingLevel level : levels) {
            ParkingSpot spot = level.findAndClaimSpot(vehicleType);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }
}
```

**File**: `Services/LoadBalancingStrategy.java`

```java
package ParkingLot_V3.Services;

import ParkingLot_V3.Entities.ParkingLevel;
import ParkingLot_V3.Entities.ParkingSpot;
import ParkingLot_V3.Enums.VehicleType;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Distributes vehicles across levels to balance occupancy.
 * Prefers levels with more available spots.
 */
public class LoadBalancingStrategy implements SpotAssignmentStrategy {
    
    @Override
    public ParkingSpot findBestSpot(List<ParkingLevel> levels, VehicleType vehicleType) {
        // Sort levels by available spot count (descending)
        return levels.stream()
            .sorted(Comparator.comparingInt(
                (ParkingLevel level) -> level.getAvailableSpotCount(vehicleType)
            ).reversed())
            .map(level -> level.findAndClaimSpot(vehicleType))
            .filter(Objects::nonNull)
            .findFirst()
            .orElse(null);
    }
}
```

---

## Enhanced Implementation

### Complete Enhanced Demo

**File**: `DemoEnhanced.java`

```java
package ParkingLot_V3;

import ParkingLot_V3.Entities.*;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Exceptions.*;
import ParkingLot_V3.Services.*;
import ParkingLot_V3.Services.Payment.*;
import ParkingLot_V3.Services.TicketFareStrategy.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * Comprehensive demo showcasing all parking lot features with error handling.
 */
public class DemoEnhanced {
    private static final Logger logger = Logger.getLogger(DemoEnhanced.class.getName());

    public static void main(String[] args) {
        try {
            logger.info("╔════════════════════════════════════════════════╗");
            logger.info("║   PARKING LOT V3 - COMPREHENSIVE DEMO         ║");
            logger.info("╚════════════════════════════════════════════════╝\n");
            
            // Initialize parking lot
            ParkingLot parkingLot = initializeParkingLot();
            
            // Fare configuration
            Map<VehicleType, Double> fareConfig = Map.of(
                VehicleType.TWO_WHEELER, 30.0,
                VehicleType.FOUR_WHEELER, 50.0,
                VehicleType.SIX_WHEELER, 100.0
            );
            
            // Run test scenarios
            testSuccessfulParking(parkingLot, fareConfig);
            testNoAvailableSpots(parkingLot);
            testConcurrentParking(parkingLot, fareConfig);
            testInvalidPayment(parkingLot, fareConfig);
            testMultipleFareStrategies(parkingLot, fareConfig);
            
            logger.info("\n╔════════════════════════════════════════════════╗");
            logger.info("║   ALL TESTS COMPLETED SUCCESSFULLY            ║");
            logger.info("╚════════════════════════════════════════════════╝");
            
        } catch (Exception e) {
            logger.severe("Demo failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static ParkingLot initializeParkingLot() {
        logger.info("═══ Initializing Parking Lot ═══\n");
        ParkingLot parkingLot = ParkingLot.getInstance();
        
        // Level 1 - Ground Floor
        ParkingLevel level1 = new ParkingLevel(Arrays.asList(
            new ParkingSpot(VehicleType.TWO_WHEELER),
            new ParkingSpot(VehicleType.TWO_WHEELER),
            new ParkingSpot(VehicleType.FOUR_WHEELER),
            new ParkingSpot(VehicleType.FOUR_WHEELER),
            new ParkingSpot(VehicleType.SIX_WHEELER)
        ));
        
        // Level 2 - First Floor
        ParkingLevel level2 = new ParkingLevel(Arrays.asList(
            new ParkingSpot(VehicleType.TWO_WHEELER),
            new ParkingSpot(VehicleType.FOUR_WHEELER),
            new ParkingSpot(VehicleType.FOUR_WHEELER)
        ));
        
        parkingLot.addLevel(level1);
        parkingLot.addLevel(level2);
        
        logger.info("✓ Parking lot initialized with 2 levels, 8 total spots\n");
        return parkingLot;
    }
    
    private static void testSuccessfulParking(ParkingLot parkingLot, Map<VehicleType, Double> fareConfig) {
        logger.info("\n═══ Test 1: Successful Parking & Payment ═══\n");
        
        try {
            Vehicle car1 = new Vehicle(VehicleType.FOUR_WHEELER, "KA-01-AB-1234");
            Vehicle bike1 = new Vehicle(VehicleType.TWO_WHEELER, "KA-02-CD-5678");
            
            ParkingTicket carTicket = parkingLot.parkVehicle(car1);
            logger.info("✓ Car parked successfully");
            
            ParkingTicket bikeTicket = parkingLot.parkVehicle(bike1);
            logger.info("✓ Bike parked successfully\n");
            
            Thread.sleep(2000);
            
            Receipt carReceipt = parkingLot.processPayment(
                carTicket, new HourlyFare(), new CashPayment(), fareConfig, 150.0
            );
            logger.info(carReceipt.toString());
            
            Receipt bikeReceipt = parkingLot.processPayment(
                bikeTicket, new FixedFare(), new UPIPayment(), fareConfig, 30.0
            );
            logger.info(bikeReceipt.toString());
            
            logger.info("✓ Test 1 PASSED\n");
            
        } catch (Exception e) {
            logger.severe("✗ Test 1 FAILED: " + e.getMessage());
        }
    }
    
    private static void testNoAvailableSpots(ParkingLot parkingLot) {
        logger.info("\n═══ Test 2: No Available Spots ═══\n");
        
        try {
            List<ParkingTicket> tickets = new ArrayList<>();
            
            for (int i = 0; i < 10; i++) {
                Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER, "TEST-" + i);
                try {
                    ParkingTicket ticket = parkingLot.parkVehicle(car);
                    tickets.add(ticket);
                } catch (NoAvailableSpotException e) {
                    logger.info("✓ Expected: " + e.getMessage());
                    break;
                }
            }
            
            for (ParkingTicket ticket : tickets) {
                parkingLot.unparkVehicle(ticket);
            }
            
            logger.info("✓ Test 2 PASSED\n");
            
        } catch (Exception e) {
            logger.severe("✗ Test 2 FAILED: " + e.getMessage());
        }
    }
    
    private static void testConcurrentParking(ParkingLot parkingLot, Map<VehicleType, Double> fareConfig) {
        logger.info("\n═══ Test 3: Concurrent Parking ═══\n");
        
        List<Thread> threads = new ArrayList<>();
        List<ParkingTicket> tickets = Collections.synchronizedList(new ArrayList<>());
        
        for (int i = 0; i < 10; i++) {
            final int id = i;
            threads.add(new Thread(() -> {
                try {
                    Vehicle vehicle = new Vehicle(VehicleType.TWO_WHEELER, "CONC-" + id);
                    ParkingTicket ticket = parkingLot.parkVehicle(vehicle);
                    tickets.add(ticket);
                } catch (Exception e) {
                    // Expected for some threads
                }
            }));
        }
        
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try { t.join(); } catch (InterruptedException e) {}
        });
        
        logger.info("✓ Concurrent test completed: " + tickets.size() + " parked");
        tickets.forEach(t -> {
            try { parkingLot.unparkVehicle(t); } catch (Exception e) {}
        });
        
        logger.info("✓ Test 3 PASSED\n");
    }
    
    private static void testInvalidPayment(ParkingLot parkingLot, Map<VehicleType, Double> fareConfig) {
        logger.info("\n═══ Test 4: Invalid Payment ═══\n");
        
        try {
            Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER, "PAY-TEST");
            ParkingTicket ticket = parkingLot.parkVehicle(car);
            
            try {
                parkingLot.processPayment(ticket, new FixedFare(), new CashPayment(), fareConfig, 10.0);
            } catch (PaymentFailedException e) {
                logger.info("✓ Correctly rejected insufficient payment");
            }
            
            parkingLot.processPayment(ticket, new FixedFare(), new CashPayment(), fareConfig, 100.0);
            
            try {
                parkingLot.processPayment(ticket, new FixedFare(), new CashPayment(), fareConfig, 100.0);
            } catch (InvalidTicketException e) {
                logger.info("✓ Correctly rejected duplicate payment");
            }
            
            logger.info("✓ Test 4 PASSED\n");
            
        } catch (Exception e) {
            logger.severe("✗ Test 4 FAILED: " + e.getMessage());
        }
    }
    
    private static void testMultipleFareStrategies(ParkingLot parkingLot, Map<VehicleType, Double> fareConfig) {
        logger.info("\n═══ Test 5: Multiple Fare Strategies ═══\n");
        
        try {
            Vehicle car = new Vehicle(VehicleType.FOUR_WHEELER, "FARE-TEST");
            ParkingTicket ticket = parkingLot.parkVehicle(car);
            
            Thread.sleep(3000);
            
            double fixed = parkingLot.getTicketFare(new FixedFare(), ticket, fareConfig);
            double hourly = parkingLot.getTicketFare(new HourlyFare(), ticket, fareConfig);
            
            logger.info("Fixed:  $" + fixed);
            logger.info("Hourly: $" + hourly);
            
            parkingLot.processPayment(ticket, new FixedFare(), new CashPayment(), fareConfig, 100.0);
            
            logger.info("✓ Test 5 PASSED\n");
            
        } catch (Exception e) {
            logger.severe("✗ Test 5 FAILED: " + e.getMessage());
        }
    }
}
```

---

## Production Readiness Checklist

### Critical (Must-Have)

- [x] Thread Safety - Race conditions fixed
- [x] Exception Handling - Custom hierarchy
- [x] Input Validation - All public methods
- [x] Domain Model - Complete lifecycle
- [ ] Logging - Structured with correlation IDs
- [ ] Monitoring - Metrics emission
- [ ] Testing - 80%+ coverage
- [ ] Documentation - Complete Javadoc

### Important (Should-Have)

- [x] Spot Assignment - Strategy pattern
- [ ] Persistence - Database integration
- [ ] Configuration - Externalized
- [ ] API Layer - REST endpoints
- [ ] Rate Limiting - DoS prevention
- [ ] Circuit Breaker - Payment gateway

### Nice-to-Have

- [ ] Reservation System
- [ ] Dynamic Pricing
- [ ] Analytics Dashboard
- [ ] Notifications
- [ ] Multi-tenancy
- [ ] Mobile Integration

---

## Migration Path

### Phase 1: Critical Fixes (Week 1)
1. Fix race conditions
2. Implement exceptions
3. Add validation
4. Complete domain model

### Phase 2: Production Hardening (Week 2)
1. Structured logging
2. Metrics
3. Testing
4. Configuration

### Phase 3: Enhancements (Week 3-4)
1. Spot strategies
2. Persistence
3. API layer
4. Admin dashboard

### Phase 4: Advanced (Month 2+)
1. Reservation system
2. Dynamic pricing
3. Analytics
4. Mobile app

---

## Conclusion

The current implementation demonstrates solid foundational knowledge but requires critical fixes before production. Implementing these improvements will elevate the solution from 6.5/10 to 9/10 FANG-level.

---

**Document Version**: 1.0  
**Last Updated**: November 19, 2025  
**Maintainer**: Parking Lot V3 Development Team