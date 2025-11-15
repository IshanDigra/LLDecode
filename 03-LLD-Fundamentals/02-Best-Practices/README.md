# Core Engineering Principles & Design Directives

This document outlines the mandatory architectural principles, design patterns, and coding practices for this project. Adherence to these guidelines is required to maintain code quality, consistency, and stability.

## 1. Architectural Blueprint

The system architecture is based on a clear separation of concerns between data, logic, and utility functions.

### Entities
Serve strictly as data transfer objects (DTOs). They are to contain state but no business logic.
```java
// Example: A simple User entity.
public class User {
    private final String userId;
    private String username;

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Getters and setters only...
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
```

### Services
Encapsulate all business logic and functionality. Services manipulate entities and are the core operational units of the application.
```java
// Example: A service for managing users.
public class UserService {
    private final Map<String, User> userStore = new ConcurrentHashMap<>();

    public void createUser(String username) {
        String id = IdGenerator.generateNextId();
        User newUser = new User(id, username);
        userStore.put(id, newUser);
    }

    public Optional<User> findUserById(String userId) {
        return Optional.ofNullable(userStore.get(userId));
    }
}
```

### Utilities
Contain stateless, reusable helper functions. The scope of utilities should be kept minimal (e.g., a synchronized ID generator).
```java
// Example: A thread-safe ID generator.
public class IdGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    public static String generateNextId() {
        return "ID-" + counter.incrementAndGet();
    }
}
```

## 2. Object-Oriented Design Principles

Strict adherence to the following OOP principles is enforced.

### 2.1. Encapsulation
All non-constant instance variables must be declared private.
Instance variables that are not intended to be modified after initialization must be declared final.
```java
public class Question {
    // `id` is immutable and private.
    private final String id;
    // `title` can be changed, but is still private.
    private String title;

    public Question(String id, String title) {
        this.id = id;
        this.title = title;
    }
    // ... getters and setters
}
```

### 2.2. Abstraction and Interfaces
Common behaviors shared across different classes must be implemented via interfaces. For example, Votable and Commentable functionalities should be defined as interfaces and implemented by relevant classes.
```java
public interface Votable {
    void upvote(User user);
    void downvote(User user);
    int getVoteCount();
}

// Question class now implements the Votable behavior.
public class Question implements Votable {
    // ... other fields
    private int voteCount = 0;

    @Override
    public void upvote(User user) {
        this.voteCount++;
    }
    // ... other implemented methods
}
```

For abstract classes, instance variables intended for subclass access must be declared protected.
Shared configurations across all subclasses that require synchronization must be implemented as static fields, initialized within a static block.
```java
public abstract class LogProcessor {
    protected final String processorName;
    protected static final Map<String, String> configurations;

    // Static block for shared configuration initialization.
    static {
        configurations = new HashMap<>();
        configurations.put("LOG_LEVEL", "INFO");
        configurations.put("OUTPUT_FORMAT", "JSON");
    }

    public LogProcessor(String processorName) {
        this.processorName = processorName;
    }

    public abstract void process(String logMessage);
}
```

## 3. Service Layer Architecture

The design of the service layer prioritizes stability and simplicity over premature complexity.

### Initial Design
All service-layer logic should initially reside within a primary Singleton class.
```java
// Example: A main Singleton class holding all initial service logic.
public class StackOverflowService {
    private static final StackOverflowService INSTANCE = new StackOverflowService();

    private StackOverflowService() {}

    public static StackOverflowService getInstance() {
        return INSTANCE;
    }

    // All business logic methods (e.g., postQuestion, answerQuestion) reside here.
    public void postQuestion(User user, String title, String body) {
        // ... implementation
    }
}
```

### Refactoring to Micro-Services
Services may only be separated into distinct classes if they are completely independent. This avoids the complexity of inter-service dependencies. If services are not independent, they must remain within the central Singleton.

## 4. Concurrency and Thread Safety

Concurrency management is critical. The strategy is to leverage concurrent data structures and apply explicit locking only when necessary.

### 4.1. Identifying Critical Sections
A critical section is any block of code that performs a read-modify-write operation on a shared resource. Examples include creating, editing, or deleting shared data.

### 4.2. Concurrency Strategy
Primary Tool: Use data structures from the java.util.concurrent package as the default mechanism for managing shared state.
```java
// No `synchronized` keyword needed here because ConcurrentHashMap is thread-safe.
public void addTagToQuestion(String questionId, String tag) {
    ConcurrentMap<String, List<String>> questionTags = new ConcurrentHashMap<>();
    questionTags.computeIfAbsent(questionId, k -> new CopyOnWriteArrayList<>()).add(tag);
}
```

The synchronized Keyword: The synchronized keyword should not be used for methods that solely operate on a single concurrent data structure. Its use is reserved for scenarios where a sequence of operations must be performed atomically.
```java
// `synchronized` is required to ensure atomicity of the check-then-act operation.
public synchronized boolean transferReputation(User from, User to, int amount) {
    if (from.getReputation() >= amount) {
        from.setReputation(from.getReputation() - amount);
        to.setReputation(to.getReputation() + amount);
        return true;
    }
    return false;
}
```

## 5. Mandated Design Patterns

The following design patterns can be saviour :
- Singleton Pattern: For managing global access to service instances.
- Strategy Design Pattern: For defining a family of algorithms and encapsulating each one.
- Observer Design Pattern: For creating a subscription model where objects are notified of state changes.
- Factory Design Pattern: For abstracting the object creation process.

## 6. Implementation Conventions

### 6.1. Data Referencing
For simplicity, mappings and relationships will be based on direct object references. While using unique IDs is the ideal practice for scalability, it is not a requirement for the current scope of this project.
```java
public class Answer {
    private final User author; // Direct object reference
    private final String answerText;

    public Answer(User author, String answerText) {
        this.author = author;
        this.answerText = answerText;
    }
}
```

### 6.2. Custom Comparators
When implementing a custom Comparator via a lambda expression, the function must return an integer (-1, 0, or 1). It must not return a boolean.
Example (Reverse Order Sort):
```java
Collections.sort(list, (a, b) -> b.compareTo(a));
```

### 6.3. Logging
Direct use of System.out or System.err for logging is forbidden. A dedicated logging framework must be used.
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {
    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());

    public void doSomething() {
        logger.info("Performing an operation.");
        // Not: System.out.println("Performing an operation.");
    }
}
```


### 7. Points to Note 
- Whenever we are solving an LLD Problem, think interms of the actual High level design port this at very basic level. from there we can deduce the Low level functioning and do the implementation. For example for the reminder service we could have reminders stored in table => Map/ List now we could have a cron job that runs every minute to get the list of reminders to be sent and then at the other end we could have a notification service as consumer that can give the functionality of sending notification via various means. 