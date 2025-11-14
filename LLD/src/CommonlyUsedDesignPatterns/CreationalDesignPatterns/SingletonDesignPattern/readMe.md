# Singleton Pattern

------------------------------------------------------------

**Definition:**  
Ensures a class has only one instance and provides a global point of access to it.

------------------------------------------------------------

**Concept:**  
The Singleton pattern restricts the instantiation of a class to a single object. This is useful when exactly one object is needed to coordinate actions across the system, such as a configuration manager or a logger. It solves the problem of accidental multiple instances and ensures consistent access to shared resources.

*Analogy:*  
A country can have only one president at a time. All official decisions and communications go through this single president.

------------------------------------------------------------

**Structure:**

| Participant | Role                                                        |
|-------------|-------------------------------------------------------------|
| Singleton   | Declares a static method for accessing the unique instance. |
| Client      | Accesses the Singleton instance as needed.                  |

```
+----------------+
|   Singleton    |
+----------------+
| - instance     |
+----------------+
| + getInstance()|
+----------------+
```

------------------------------------------------------------

**Real World Examples:**
- Logger: Only one logger instance writes to a log file.
- Configuration Manager: Single source for application settings.
- Print Spooler: Manages print jobs system-wide.

------------------------------------------------------------

**Code Example (Java):**
```java
// Singleton class template
public class Singleton {
    private static Singleton instance;

    // Private constructor prevents instantiation from other classes
    private Singleton() {}

    // Global access point
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

    // Usage
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
// s1 and s2 refer to the same instance
```

------------------------------------------------------------

**Enhancement: Thread-Safe Singleton Implementation (Java)**

The basic Singleton implementation is not thread-safe. In multithreaded environments, multiple threads could create different instances simultaneously. To address this, you can use synchronization or double-checked locking.

**1. Synchronized Method (Simple but Less Efficient):**
```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**2. Double-Checked Locking (Efficient and Thread-Safe):**
```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

> **Note:**
> - Double-checked locking is faster because it only uses locking when the Singleton is created for the first time. After that, getting the instance is quick and doesn't need locking.
> - The `volatile` keyword stops thread-level caching. It makes sure every thread always sees the latest, fully created Singleton object, not an old or half-created one.

------------------------------------------------------------

**Summary Table:**

| Benefit             | Description                                                     |
|---------------------|-----------------------------------------------------------------|
| Single Instance     | Guarantees one and only one instance of the class               |
| Controlled Access   | Provides a global access point                                  |
| Lazy Initialization | Instance is created only when needed                            |
| Extensible          | Can be subclassed if needed                                     |

**When to Use:**
- When only one instance of a class is needed
- When global access to the instance is required
- When shared resources or configurations must be coordinated
