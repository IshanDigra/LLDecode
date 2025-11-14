# Common LLD Patterns & Solutions

This document outlines frequently used patterns and solutions for common Low-Level Design (LLD) problems, such as vending machines, inventory management, and payment gateways.

## 1. Vending Machine: State Design Pattern

For systems that behave like a state machine, such as a vending machine, the State Design Pattern is the most effective approach.

### Key States & Components:

**States:**
- **IdleState:** The machine is waiting for a user to start a transaction.
- **TransactionState:** The user is selecting items and inserting payment.
- **DispensingState:** The machine is dispensing the selected product.

**Context:** A central class (VendingMachine) that holds the current state and manages transitions between states.

**Interface:** A State interface defining common methods (e.g., selectItem, insertMoney, dispenseItem).

```java
// State Interface
public interface VendingMachineState {
    void selectProduct(VendingMachine machine, Product product);
    void insertMoney(VendingMachine machine, double amount);
    void dispenseProduct(VendingMachine machine);
}

// Context Class
public class VendingMachine {
    private VendingMachineState currentState;
    private Product selectedProduct;
    // ... other fields

    public VendingMachine() {
        this.currentState = new IdleState();
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }
    // ... methods that delegate to the current state object
}
```

## 2. Inventory Management Strategies

An InventoryService is a critical component in e-commerce platforms and vending machines. Its implementation can vary in complexity.

### Core Operations:
- `updateStock(productId, quantity)`
- `restock(productId, quantity)`
- `isAvailable(productId)`

### Implementation Approaches:

**Simple Approach:** A single map for products and their quantities. Suitable for simple, single-user scenarios.
```java
Map<Product, Integer> inventory = new HashMap<>();
```

**Ideal Approach:** Separate maps for registered products and their counts, using a Product ID as the key for efficient lookups. This offers better organization and scalability.
```java
Map<String, Product> registeredProducts = new ConcurrentHashMap<>();
Map<String, Integer> productCounts = new ConcurrentHashMap<>();
```

**Advanced Approach (with Notifications):** Extends the ideal approach by incorporating the Observer Pattern to notify administrators or other systems about inventory changes (e.g., low stock alerts).
```java
class InventoryService {
    private Map<String, Product> registeredProducts;
    private Map<String, Integer> productCounts;
    private List<Observer> observers; // Observers to notify

    public void updateStock(String productId, int quantity) {
        // ... update logic
        if (productCounts.get(productId) < LOW_STOCK_THRESHOLD) {
            notifyObservers("LOW_STOCK", productId);
        }
    }
    // ... other methods and observer logic
}
```

### E-commerce Cart Management Strategy:

In shared-access systems like e-commerce platforms, inventory should be managed proactively to prevent overselling.

- **On Add to Cart:** Decrease the inventory count for the product.
- **Timeout:** If a user does not complete the purchase within a set time (e.g., 10 minutes), release the item from their cart and restore the inventory count.

## 3. Payment Gateway: Strategy + Factory Pattern

For systems requiring multiple payment methods, combining the Strategy and Factory patterns provides a flexible and maintainable solution.

**Strategy Interface (PaymentStrategy):** Defines a common method for processing payments (e.g., pay(amount)).

**Concrete Strategies:** Implementations for different payment methods (CreditCardPayment, UpiPayment, NetBankingPayment).

**Factory (PaymentStrategyFactory):** A factory class to create the appropriate payment strategy object based on user selection.

```java
// Strategy Interface
public interface PaymentStrategy {
    boolean pay(double amount);
}

// Concrete Strategy
public class CreditCardPayment implements PaymentStrategy {
    // ... fields for card details
    @Override
    public boolean pay(double amount) {
        // Logic to process credit card payment
        return true;
    }
}

// Factory
public class PaymentStrategyFactory {
    public static PaymentStrategy getStrategy(String paymentType) {
        if ("CREDIT_CARD".equalsIgnoreCase(paymentType)) {
            return new CreditCardPayment();
        } else if ("UPI".equalsIgnoreCase(paymentType)) {
            return new UpiPayment();
        }
        // ... other cases
        return null;
    }
}
```

**Note:** Payments should always be made against a reservation, and the reservation status should be updated accordingly (e.g., PENDING, COMPLETED, FAILED).

## 4. Messaging & Social Platforms: Behavior-based Interfaces

For platforms like Stack Overflow or social media apps, use small, behavior-focused interfaces to add functionalities like commenting, voting, and sharing.

### Interface Segregation: Create specific interfaces for each behavior.
- **Commentable:** `addComment(Comment c)`, `getComments()`
- **Votable:** `upvote()`, `downvote()`, `getVoteCount()`
- **Likeable:** `like()`, `unlike()`, `getLikeCount()`

This approach allows classes to implement only the behaviors they need, promoting a flexible and extensible design.

```java
public interface Votable {
    void upvote();
    void downvote();
    int getVoteCount();
}

public class Post implements Votable, Commentable {
    // Implementation of both Votable and Commentable interfaces
}

public class Comment implements Votable {
    // Comments can be voted on but not commented on further.
}
```

## 5. User Authentication

For simple, time-bound scenarios, a basic map-based authentication system is sufficient.

- Use a `Map<String, String>` to store (email, password) pairs.
- **Registration:** Add a new entry to the map.
- **Authentication:** Look up the email and compare the provided password with the stored one.

```java
public class AuthenticationService {
    private final Map<String, String> userCredentials = new ConcurrentHashMap<>();

    public boolean register(String email, String password) {
        // Basic validation for email and password
        userCredentials.putIfAbsent(email, password);
        return true;
    }

    public boolean login(String email, String password) {
        return userCredentials.containsKey(email) && userCredentials.get(email).equals(password);
    }
}
```
