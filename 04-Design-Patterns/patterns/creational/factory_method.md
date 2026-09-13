# Factory Method Pattern

**Definition:**
Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

**Concept:**
The Factory Method pattern provides a way to delegate the instantiation logic to subclasses. Instead of calling a constructor directly, the client calls a factory method, which returns an instance of a class that implements a common interface. This promotes loose coupling and makes it easy to introduce new types without changing existing code.

**Analogy:**
When you visit a restaurant, you simply order a dish by name. You don’t know (or need to know) the recipe or how the kitchen prepares it. The kitchen receives your order, handles all the details, and serves you the correct dish. In the Factory Method pattern, the kitchen is like the factory, and the dish is the product you receive.

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

**Benefits:**
- Hides object creation details from the client
- Makes code easier to extend and maintain

**When to Use:**
- You want to delegate object instantiation to subclasses
- You want to avoid changing client code when adding new types
