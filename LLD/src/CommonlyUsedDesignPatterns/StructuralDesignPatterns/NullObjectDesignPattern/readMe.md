# Null Object Design Pattern

------------------------------------------------------------

**Definition:**  
A behavioral pattern that uses a special object (the "null object") to represent the absence of a real object, avoiding null checks and providing default, do-nothing behavior.

------------------------------------------------------------

**Concept:**  
Instead of returning `null` when an object is missing, return a "null object" that implements the same interface but does nothing (or returns a default value). This keeps client code clean and safe from null pointer errors.

------------------------------------------------------------

**Structure:**

| **Role**         | **Example**                  |
|------------------|-----------------------------|
| AbstractObject   | Interface (e.g., `Customer`) |
| RealObject       | Provides real behavior (e.g., `RealCustomer`) |
| NullObject       | Does nothing/returns default (e.g., `NullCustomer`) |
| Client           | Uses the object (e.g., `OrderSystem`) |

**Diagram:**
```
+--------+         +--------------+
| Client | ----->  | AbstractObj  |
+--------+         +--------------+
                        ^
                +-------+-------+
                |               |
         +-------------+ +-------------+
         | RealObject  | | NullObject  |
         +-------------+ +-------------+
```
> The client uses the abstract interface and never needs to check for null.

------------------------------------------------------------

**Why Use a Null Object?**
- Avoids repetitive null checks in client code
- Prevents null pointer exceptions
- Provides safe default behavior
- Makes code more readable and maintainable

------------------------------------------------------------

**Real World Examples:**
- Logging: a `NullLogger` that silently ignores log messages
- Collections: returning an empty list instead of `null`
- UI: a `NullEventHandler` that does nothing if no handler is set
- Databases: a `NullDatabaseConnection` that safely ignores queries

------------------------------------------------------------

**Code Example (Generalized Template):**
```java
// AbstractObject
interface Customer {
    String getName();
}
// RealObject
class RealCustomer implements Customer {
    private String name;
    public RealCustomer(String name) { this.name = name; }
    public String getName() { return name; }
}
// NullObject
class NullCustomer implements Customer {
    public String getName() { return "Not Available"; }
}
// Factory
class CustomerFactory {
    public static Customer getCustomerById(int id) {
        if (id == 123) return new RealCustomer("John Doe");
        else return new NullCustomer();
    }
}
// Usage
Customer customer = CustomerFactory.getCustomerById(id);
System.out.println(customer.getName());
```
> Note: The client never checks for null—just calls the method!

------------------------------------------------------------

**Additional Insights:**
- Null Objects are useful when a collaborator is required, but sometimes you want that collaborator to do nothing (e.g., a "no-op" strategy for movement or color in a game).
- Null Objects can be considered "smart"—they always know exactly what to do (which is nothing or a safe default), so the client code never has to worry about special cases.
- Sometimes, you may need more than one type of Null Object if there are different ways to "do nothing" or provide different default behaviors.

------------------------------------------------------------

**Summary:**
- Null Object provides a safe default instead of `null`
- Eliminates null checks and exceptions
- Keeps code simple, robust, and easy to extend

------------------------------------------------------------
