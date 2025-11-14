# Factory Method Pattern

------------------------------------------------------------

**Definition:**  
Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

------------------------------------------------------------

**Concept:**  
The Factory Method pattern provides a way to delegate the instantiation logic to subclasses. Instead of calling a constructor directly, the client calls a factory method, which returns an instance of a class that implements a common interface. This promotes loose coupling and makes it easy to introduce new types without changing existing code.

---

**Analogy:**  
When you visit a restaurant, you simply order a dish by name. You don’t know (or need to know) the recipe or how the kitchen prepares it. The kitchen receives your order, handles all the details, and serves you the correct dish. In the Factory Method pattern, the kitchen is like the factory, and the dish is the product you receive.


> **Note:** The Factory Method pattern hides the details of object creation from the client. This makes your code easier to extend and maintain, because adding new types doesn't require changing existing client code.

---

**Structure:**

| Participant        | Role                                                        |
|--------------------|-------------------------------------------------------------|
| Animal (Interface) | Declares the speak() method                                 |
| Duck, Tiger        | Implement Animal, each with their own speak()               |
| AnimalFactory      | Has a method to return an Animal based on input             |

```
+-------------------+ (based on animal type)  +-------------------+
|   AnimalFactory   |-----------------------> |      Animal       |
+-------------------+                         +-------------------+
                                                   /        \
                                                  /          \
                                         +--------+          +--------+
                                         |  Duck  |          | Tiger  |
                                         +--------+          +--------+
                                         |speak() |          |speak() |
                                         +--------+          +--------+
```

------------------------------------------------------------

**Real World Examples:**
- Document editor: Different document types (Word, PDF, etc.) created by different factories.
- Vehicle factory: Cars, bikes, and trucks are all created by their respective factories.
- GUI toolkit: Different OS toolkits create buttons and windows in their own style.

------------------------------------------------------------

**Code Example (Java):**
```java
interface Animal {
    void speak();
}

class Duck implements Animal {
    public void speak() { System.out.println("Quack Quack"); }
}

class Tiger implements Animal {
    public void speak() { System.out.println("Roar"); }
}

class AnimalFactory {
    // Returns an Animal based on type
    public static Animal getAnimal(String type) {
        if ("duck".equalsIgnoreCase(type)) return new Duck();
        if ("tiger".equalsIgnoreCase(type)) return new Tiger();
        return null;
    }
}
```

------------------------------------------------------------

**Summary Table:**

| Benefit           | Description                                               |
|-------------------|-----------------------------------------------------------|
| Loose Coupling    | Client code is decoupled from concrete product classes    |
| Open/Closed       | New product types can be introduced without changing code |
| Flexibility       | Instantiation logic can change at runtime                 |

**When to Use:**
- When a class can't anticipate the type of objects it must create
- When subclasses should specify the objects to be created
- When you want to localize the knowledge of which helper subclass is the delegate
