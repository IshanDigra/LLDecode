# Parking Lot Management System V3

## Problem Statement

The parking lot should have multiple levels, each level with a certain number of parking spots. The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks. Each parking spot should be able to accommodate a specific type of vehicle. The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits. The system should track the availability of parking spots and provide real-time information to customers. The system should handle multiple entry and exit points and support concurrent access. Bonus: Think about if payment needs to be made against a booking/ParkingTicket.

## Happy Flow

1. Vehicle reaches the Parking Lot Manager
2. System tracks the availability of parking spots based on vehicle type
3. An available parking spot is assigned to the vehicle
4. Vehicle goes to that level and parks
5. Parking ticket is generated with timestamp and parking details
6. Upon exit, user selects pricing strategy (fixed/hourly)
7. System calculates fare based on the chosen strategy
8. User submits payment using selected payment method (cash/UPI)
9. Ticket is submitted back and parking spot is released

## Entities

| Entity | Properties | Description |
|--------|-----------|-------------|
| **ParkingSpot** | `id: String`<br>`type: VehicleType`<br>`status: ParkingStatus` | Represents an individual parking spot that can accommodate a specific vehicle type |
| **ParkingLevel** | `id: String`<br>`spots: Map<VehicleType, List<ParkingSpot>>` | Represents a level in the parking lot containing multiple parking spots organized by vehicle type |
| **Vehicle** | `numberPlate: String`<br>`type: VehicleType` | Represents a vehicle with its registration and type information |
| **ParkingTicket** | `id: String`<br>`vehicle: Vehicle`<br>`spot: ParkingSpot`<br>`time: LocalDateTime`<br>`status: PaymentStatus` | Represents a parking ticket generated when a vehicle is parked |

## Enums

| Enum | Values | Description |
|------|--------|-------------|
| **VehicleType** | `TWO_WHEELER`, `FOUR_WHEELER`, `SIX_WHEELER` | Defines the supported vehicle types |
| **ParkingStatus** | `OCCUPIED`, `UNOCCUPIED` | Defines the current status of a parking spot |
| **PaymentStatus** | `PENDING`, `COMPLETED` | Defines the payment status of a parking ticket |

## Services & Core Functionalities

| Service | Responsibilities | Key Methods |
|---------|-----------------|-------------|
| **ParkingLot** (Singleton) | Manages all parking operations and levels | `parkVehicle(Vehicle): ParkingTicket` - Parks vehicle and generates ticket<br>`getParkingSpots(VehicleType): List<ParkingSpot>` - Retrieves available spots for vehicle type<br>`getTicketFare(FareStrategy, ParkingTicket, Map): Double` - Calculates fare using strategy<br>`makePayment(PaymentStrategy, double, double, ParkingTicket): void` - Processes payment and releases spot<br>`unparkVehicle(ParkingTicket): void` - Releases parking spot<br>`addLevel(ParkingLevel): void` - Adds new parking level |
| **FareStrategy** (Strategy Interface) | Defines fare calculation contract | `getTicketFare(ParkingTicket, Map<VehicleType, Double>): double` |
| **FixedFare** | Implements fixed pricing strategy | Returns fixed fare based on vehicle type |
| **HourlyFare** | Implements hourly pricing strategy | Calculates fare based on parking duration |
| **PaymentStrategy** (Strategy Interface) | Defines payment processing contract | `makePayment(double): Boolean` |
| **CashPayment** | Implements cash payment processing | Processes cash transactions |
| **UPIPayment** | Implements UPI payment processing | Processes UPI transactions |

## Critical Sections

| Critical Section | Synchronization Mechanism | Purpose |
|-----------------|---------------------------|---------|
| **Parking Lot Singleton Instantiation** | Double-checked locking with `volatile` | Ensures thread-safe singleton creation |
| **Vehicle Parking** | `synchronized` method in `ParkingLot.parkVehicle()` | Prevents race conditions when assigning spots |
| **Spot Parking/Unparking** | `synchronized` methods in `ParkingSpot.parkVehicle()` and `unparkVehicle()` | Ensures atomic state changes for spots |
| **Payment Processing** | `synchronized` method in `ParkingLot.makePayment()` | Prevents concurrent payment for same ticket |
| **Spot Release** | `synchronized` method in `ParkingLot.unparkVehicle()` | Ensures atomic spot release operation |
| **Level Spot Storage** | `ConcurrentHashMap` in `ParkingLevel` | Thread-safe concurrent access to spot collections |
| **Level List** | `CopyOnWriteArrayList` in `ParkingLot` | Thread-safe concurrent access to levels |

## Exceptions

Custom exceptions are thrown as `RuntimeException` with specific messages:

| Exception Scenario | Message |
|-------------------|---------|
| Spot already occupied | "Spot Already Booked" |
| Vehicle type mismatch | "Vehicle Type is not compatible" |
| Unparking empty spot | "Parking spot is already unoccupied" |
| Invalid level input | "Invalid Input" |
| Payment already completed | "the Payment has already been made!" |
| Insufficient payment amount | "please pay the quoted amount: $[amount]" |
| Payment processing failure | "payment failed" |

## Utilities

| Utility Class | Purpose | Methods |
|---------------|---------|---------|
| **IdGeneratorUtil** | Generates unique identifiers for entities using `AtomicLong` for thread safety | `generateSpotId(): String` - Generates parking spot ID<br>`generateLevelId(): String` - Generates level ID<br>`generateTicketId(): String` - Generates ticket ID |

## Design Patterns Used

| Pattern | Application | Benefits |
|---------|-------------|----------|
| **Singleton** | `ParkingLot` class ensures single instance | Centralized parking lot management and prevents multiple instances |
| **Strategy** | `FareStrategy` and `PaymentStrategy` interfaces | Enables flexible fare calculation (Fixed/Hourly) and payment methods (Cash/UPI) without modifying core logic |
| **Factory** (Implicit) | Dynamic creation of fare and payment strategies | Allows runtime selection of pricing and payment strategies |

## Questions to Ask

1. **Capacity and Scale**: What is the maximum number of levels and spots per level the system should support?
2. **Reservation System**: Should the system support advance booking/reservation of parking spots?
3. **Pricing Strategy**: Can pricing vary by time of day, weekdays vs. weekends, or special events?
4. **Vehicle Size Flexibility**: Can a larger spot accommodate a smaller vehicle (e.g., FOUR_WHEELER spot for TWO_WHEELER)?
5. **Payment Failure Handling**: What happens if payment fails? Is there a retry mechanism or grace period?
6. **Parking Duration Limits**: Are there maximum parking duration limits or overtime charges?
7. **Spot Assignment Strategy**: Should spots be assigned based on proximity to entrance, specific floor preference, or other criteria?
8. **Cancellation Policy**: Can users cancel their parking and get a refund before payment is completed?
9. **Multiple Entry/Exit Points**: How are multiple entry and exit points handled in the system?
10. **Real-time Availability**: How frequently should the system update spot availability for customers?
11. **Historical Data**: Should the system maintain historical records of parking transactions for analytics?
12. **Partial Payments**: Are partial payments or split payments allowed?
13. **VIP/Reserved Spots**: Should the system support reserved spots for specific users or vehicle types?
14. **Dynamic Pricing**: Should pricing change based on demand or occupancy levels?
15. **Integration**: Does the system need to integrate with external payment gateways or vehicle recognition systems?
