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

## 6. Scheduled Reminder & Notification System

For systems requiring time-based notifications and reminders (e.g., task management, calendar events, subscription renewals), a scheduled reminder pattern provides an elegant solution using background threads and delayed execution.

### Core Components:

**Reminder Entity:** A data class encapsulating what to remind, when to trigger, and associated metadata.

**Scheduler Service:** Manages scheduling, delay calculation, and execution of reminders using thread pools.

**Notification Service Interface:** Defines contract for different notification delivery mechanisms.

**Concrete Implementations:** Multiple notification channels (Console, Email, SMS, Push Notifications).

### Implementation Approach:

Use `ScheduledExecutorService` for efficient background task execution with configurable thread pools.

```java
// Generic Reminder Entity
public class Reminder<T> {
    private final T subject;           // What to remind about (Task, Event, etc.)
    private final LocalDateTime scheduledTime;
    private final String message;
    
    public Reminder(T subject, LocalDateTime scheduledTime, String message) {
        this.subject = subject;
        this.scheduledTime = scheduledTime;
        this.message = message;
    }
    
    public T getSubject() { return subject; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public String getMessage() { return message; }
}

// Notification Service Interface
public interface NotificationService<T> {
    void sendNotification(Reminder<T> reminder);
}

// Console Implementation
public class ConsoleNotificationService<T> implements NotificationService<T> {
    private static final Logger logger = Logger.getLogger(ConsoleNotificationService.class.getName());
    
    @Override
    public void sendNotification(Reminder<T> reminder) {
        logger.info(String.format("[REMINDER] %s - Subject: %s",
            reminder.getMessage(),
            reminder.getSubject().toString()));
    }
}

// Email Implementation
public class EmailNotificationService<T> implements NotificationService<T> {
    private final EmailClient emailClient;
    
    public EmailNotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }
    
    @Override
    public void sendNotification(Reminder<T> reminder) {
        // Send email notification
        emailClient.send(extractRecipient(reminder.getSubject()), 
                        reminder.getMessage());
    }
    
    private String extractRecipient(T subject) {
        // Extract recipient email from subject
        return "user@example.com";
    }
}

// Reminder Scheduler
public class ReminderScheduler<T> {
    private final ScheduledExecutorService scheduler;
    private final NotificationService<T> notificationService;
    
    public ReminderScheduler(NotificationService<T> notificationService, int threadPoolSize) {
        this.scheduler = Executors.newScheduledThreadPool(threadPoolSize);
        this.notificationService = notificationService;
    }
    
    public void scheduleReminder(Reminder<T> reminder) {
        LocalDateTime now = LocalDateTime.now();
        long delayInSeconds = ChronoUnit.SECONDS.between(now, reminder.getScheduledTime());
        
        if (delayInSeconds > 0) {
            scheduler.schedule(
                () -> sendReminder(reminder),
                delayInSeconds,
                TimeUnit.SECONDS
            );
        } else {
            // Immediate notification if time has passed
            sendReminder(reminder);
        }
    }
    
    private void sendReminder(Reminder<T> reminder) {
        notificationService.sendNotification(reminder);
    }
    
    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
```

### Usage Example:

```java
// Task Management System
public class Task {
    private String id;
    private String title;
    private LocalDateTime dueDate;
    private TaskStatus status;
    
    // Constructor, getters, setters
}

public class TaskManagementSystem {
    private final ReminderScheduler<Task> reminderScheduler;
    
    public TaskManagementSystem() {
        NotificationService<Task> notificationService = new ConsoleNotificationService<>();
        this.reminderScheduler = new ReminderScheduler<>(notificationService, 5);
    }
    
    public void assignTask(Task task, User user) {
        // Assign task logic
        
        // Schedule reminder for task deadline
        Reminder<Task> reminder = new Reminder<>(
            task,
            task.getDueDate(),
            String.format("Task '%s' is due. Assigned to: %s", 
                         task.getTitle(), user.getName())
        );
        reminderScheduler.scheduleReminder(reminder);
    }
}
```

### Key Design Decisions:

| Aspect | Choice | Rationale |
|--------|--------|----------|
| Thread Pool | ScheduledExecutorService | Efficient resource management, built-in scheduling support |
| Generic Type | Reminder<T> | Reusable across different domain objects (Task, Event, Subscription) |
| Strategy Pattern | NotificationService interface | Easily swap notification channels without changing scheduler |
| Delay Calculation | ChronoUnit.SECONDS.between() | Precise time-based scheduling with Java Time API |
| Thread Safety | Thread-safe executor | Safe concurrent access for multiple schedulers |

### Use Cases:

- **Task Management:** Remind users about task deadlines, overdue tasks
- **Calendar Systems:** Send event notifications before meetings
- **Subscription Services:** Alert users about renewal dates, trial expiration
- **E-commerce:** Notify about abandoned carts, order deliveries
- **Healthcare:** Medication reminders, appointment notifications
- **Education:** Assignment deadlines, exam reminders

### Best Practices:

**Graceful Shutdown:** Always call `shutdown()` on the scheduler to release resources properly.

**Error Handling:** Wrap notification logic in try-catch blocks to prevent thread termination on failures.

**Conditional Notifications:** Check entity state before sending (e.g., don't remind if task is already completed).

```java
private void sendReminder(Reminder<Task> reminder) {
    Task task = reminder.getSubject();
    if (task.getStatus() == TaskStatus.ACTIVE) {
        notificationService.sendNotification(reminder);
    }
}
```

**Multiple Notification Channels:** Use Composite pattern to send through multiple channels simultaneously.

```java
public class CompositeNotificationService<T> implements NotificationService<T> {
    private final List<NotificationService<T>> services;
    
    public CompositeNotificationService(List<NotificationService<T>> services) {
        this.services = services;
    }
    
    @Override
    public void sendNotification(Reminder<T> reminder) {
        services.forEach(service -> service.sendNotification(reminder));
    }
}
```

**Recurring Reminders:** Extend for periodic reminders using `scheduleAtFixedRate()` or `scheduleWithFixedDelay()`.

```java
public void scheduleRecurringReminder(Reminder<T> reminder, long intervalSeconds) {
    scheduler.scheduleAtFixedRate(
        () -> sendReminder(reminder),
        0,
        intervalSeconds,
        TimeUnit.SECONDS
    );
}
```