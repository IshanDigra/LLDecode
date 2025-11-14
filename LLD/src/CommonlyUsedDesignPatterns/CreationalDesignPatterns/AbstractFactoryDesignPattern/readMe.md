# Abstract Factory Pattern

------------------------------------------------------------

**Definition:**  
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

------------------------------------------------------------

**Concept:**  
The Abstract Factory pattern lets you produce families of related objects without exposing their concrete classes. It is useful when your code needs to work with various families of products, but you want to avoid hard-coding their classes. This promotes consistency among products and makes the codebase flexible and easy to extend.

---

*Analogy:*  
Imagine a furniture store that can supply entire sets of furniture (e.g., Victorian or Modern). You order a set, and the store provides you with a matching chair, sofa, and coffee table—all in the same style. You don’t need to know how each piece is made or how the styles are coordinated; the store (factory) handles it all.

> **Note:** The Abstract Factory pattern keeps your code independent from the concrete classes of products. It allows you to switch entire product families easily and ensures that products from the same family are compatible. This pattern is also called the "factory of factories" pattern.

---

**Structure:**

| Participant             | Example from Furniture Scenario                  | Role                                                      |
|------------------------|--------------------------------------------------|-----------------------------------------------------------|
| AbstractFactory        | FurnitureFactory                                 | Declares methods to create abstract products (Chair, Sofa)|
| ConcreteFactory        | ModernFurnitureFactory, VictorianFurnitureFactory | Implements creation methods for a specific style          |
| AbstractProduct        | Chair, Sofa                                      | Declares interface for a type of product                  |
| ConcreteProduct        | ModernChair, VictorianChair, ModernSofa, VictorianSofa | Implements the AbstractProduct interface           |
| Client                 | Application code                                 | Uses only interfaces, not concrete classes                |

```
           +---------------------+
           |  FurnitureFactory   |   <-- Abstract Factory
           +---------------------+
           | +createChair()      |
           | +createSofa()       |
           +---------------------+
                /           \
               /             \
+---------------------+    +------------------------+
| ModernFurnitureFactory | | VictorianFurnitureFactory |  <-- Concrete Factories
+---------------------+    +------------------------+
| +createChair()      |    | +createChair()         |
| +createSofa()       |    | +createSofa()          |
+---------------------+    +------------------------+
       |      |                  |            |
       v      v                  v            v
+----------+ +----------+   +--------------+  +-------------+
|ModernChair| |ModernSofa|  |VictorianChair|  |VictorianSofa|  <-- Concrete Products
+----------+ +----------+   +--------------+  +-------------+
```
> **Note:** ModernChair and VictorianChair can implement the Chair interface, while ModernSofa and VictorianSofa can implement the Sofa interface. This allows the client code to use the products interchangeably via their interfaces.
------------------------------------------------------------

**Real World Examples:**
- UI toolkits: Each OS (Windows, Mac, Linux) provides its own set of UI components (buttons, checkboxes, etc.)
- Car factories: Different brands produce their own families of car parts (engine, wheels, seats, etc.)
- Theme kits: Applications that can switch between light and dark theme families

------------------------------------------------------------

**Standard Template (Java):**
```java
// Abstract Products
interface Chair { }
interface Sofa { }

// Concrete Products
class ModernChair implements Chair { }
class VictorianChair implements Chair { }
class ModernSofa implements Sofa { }
class VictorianSofa implements Sofa { }

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

// Concrete Factories
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() { return new ModernChair(); }
    public Sofa createSofa() { return new ModernSofa(); }
}
class VictorianFurnitureFactory implements FurnitureFactory {
    public Chair createChair() { return new VictorianChair(); }
    public Sofa createSofa() { return new VictorianSofa(); }
}
```

------------------------------------------------------------

**Summary Table:**

| Benefit           | Description                                                    |
|-------------------|----------------------------------------------------------------|
| Consistency       | Ensures products from the same family are used together        |
| Flexibility       | Easy to switch product families at runtime                     |
| Scalability       | Adding new product families is straightforward                 |



**When to Use:**
- When your code needs to work with various families of related products
- When you want to ensure products from the same family are used together
- When you want to avoid tight coupling with concrete product classes
