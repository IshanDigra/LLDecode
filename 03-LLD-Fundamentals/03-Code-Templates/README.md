# LLD Code Templates

This document provides supplementary coding standards, advanced implementation guidelines, and ready-to-use code templates for LLD development.

## 1. Advanced Best Practices

### 1.1. Exception Handling

Proper exception handling is crucial for building robust applications.

**Custom Exceptions:** Define custom exceptions to handle specific error scenarios in your application domain.
```java
// Custom exception for application-specific errors
public class OrderProcessingException extends RuntimeException {
    public OrderProcessingException(String message) {
        super(message);
    }
}
```

**Runtime Exceptions:** In time-bound environments like competitive programming or system design interviews, using unchecked RuntimeException can simplify method signatures.
```java
public void processOrder(Order order) throws RuntimeException {
    if (order == null || order.isInvalid()) {
        throw new OrderProcessingException("Invalid order details provided.");
    }
    // ... processing logic
}
```

### 1.2. Design Pattern Selection Guide

While several patterns are standard, the State pattern is essential for managing objects with complex state transitions.

**State Pattern:** Use when an object's behavior changes depending on its internal state, effectively creating a state machine.

**When to Use Which Pattern:**
- **Singleton:** A single, global access point to a service is required.
- **Strategy:** You need to switch between multiple algorithms or behaviors for the same operation at runtime.
- **Observer:** Event-driven notifications are needed to decouple components.
- **Factory:** The creation logic for an object is complex or needs to be centralized.
- **State:** An object must alter its behavior as its internal state changes.

### 1.3. Service Organization and Decoupling

Services should be independent and loosely coupled. Use dependency injection to manage relationships between services.
```java
// Independent services for distinct responsibilities.
public class PaymentService {
    public boolean processPayment(User user, double amount) {
        // Payment processing logic
        return true;
    }
}

// OrderService depends on PaymentService, which is injected.
public class OrderService {
    private final PaymentService paymentService;

    // Dependency is provided via the constructor.
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(Order order) {
        // ... logic to validate order
        paymentService.processPayment(order.getUser(), order.getTotalAmount());
        // ... logic to finalize order
    }
}
```

### 1.4. Advanced Concurrency: Async Operations

For non-blocking or scheduled tasks, leverage Java's modern concurrency utilities.

**CompletableFuture:** Use for asynchronous, non-blocking background tasks.
```java
// Run a task on a background thread pool.
CompletableFuture.runAsync(() -> {
    System.out.println("Executing a background task for data processing.");
    // ... background logic
});
```

**ScheduledExecutorService:** Use for recurring tasks or reminders.
```java
// Schedule a task to run every hour.
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.scheduleAtFixedRate(() -> {
    System.out.println("Sending hourly email reminders...");
    // ... reminder logic
}, 0, 1, TimeUnit.HOURS);
```

## 2. Code Templates

### 2.1. Utility Templates

**Date Utility Functions**
```java
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end) + 1;
    }
    
    public static String formatDate(LocalDate date) {
        return date.format(dtf);
    }
    
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, dtf);
    }
    
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    public static long secondsBetween(Timestamp start, Timestamp end) {
        return (end.getTime() - start.getTime()) / 1000;
    }
}
```

**Scanner Input Utility**
```java
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static String readString() { return scanner.next(); }
    public static String readLine() { return scanner.nextLine(); }
    public static int readInt() { return scanner.nextInt(); }
    public static float readFloat() { return scanner.nextFloat(); }
    public static void close() { scanner.close(); }
}
```

**Collection Utilities**
```java
import java.util.*;

public class CollectionUtils {
    public static <T> void sortReverse(List<T> list, Comparator<T> comparator) {
        list.sort(comparator.reversed());
    }
    
    public static void sortByPriority(List<Task> tasks) {
        Collections.sort(tasks, (a, b) -> Integer.compare(b.getPriority(), a.getPriority()));
    }
}
```

### 2.2. Service & Pattern Templates

**Base Service Template**
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public abstract class BaseService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    protected void validateNotNull(Object input, String message) {
        if (input == null) {
            throw new IllegalArgumentException(message);
        }
    }
    
    protected void logOperation(String operation, Object... params) {
        logger.info("Executing {} with params: {}", operation, Arrays.toString(params));
    }
}
```

**Singleton Service Manager (Registry)**
```java
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {
    private static volatile ServiceManager instance;
    private final Map<String, Object> serviceRegistry = new ConcurrentHashMap<>();
    
    private ServiceManager() {}
    
    public static ServiceManager getInstance() {
        if (instance == null) {
            synchronized (ServiceManager.class) {
                if (instance == null) {
                    instance = new ServiceManager();
                }
            }
        }
        return instance;
    }
    
    public void registerService(String name, Object service) {
        serviceRegistry.put(name, service);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T getService(String name) {
        return (T) serviceRegistry.get(name);
    }
}
```

**Observer/Subject Pattern Template**
```java
import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void update(String event, Object data);
}

public class Subject {
    private final List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer) { observers.add(observer); }
    public void removeObserver(Observer observer) { observers.remove(observer); }
    
    public void notifyObservers(String event, Object data) {
        for (Observer observer : observers) {
            observer.update(event, data);
        }
    }
}
```

## 3. Related Resources

- **Problem-Solving Approach:** Systematic methodology for tackling LLD problems.
- **Common Patterns:** Frequently used architectural and coding solutions.
- **Core Principles:** Foundational coding standards and design directives.
