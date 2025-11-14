# Decorator Design Pattern

------------------------------------------------------------

**Definition:**  
Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

------------------------------------------------------------

**Concept:**  
The Decorator pattern allows behavior to be added to individual objects without affecting the behavior of other objects from the same class. It follows the Open/Closed principle by allowing functionality to be extended without modifying existing code.

---

**Analogy:**  
Think of a pizza shop. You start with a basic pizza (Margherita or Farmhouse) and then add various toppings (cheese, mushrooms, salami). Instead of creating a separate class for each possible pizza-topping combination (which would lead to class explosion), you "decorate" the base pizza with toppings.

> **Note:** Decorator pattern is ideal when you need to add responsibilities to objects without rewriting or altering existing code. It creates a set of decorator classes that are used to wrap concrete components.

---

**Structure:**

| Participant        | Role                                                        |
|--------------------|-------------------------------------------------------------|
| Component          | Defines the interface for objects that can have responsibilities added | 
| ConcreteComponent  | The basic object to which additional responsibilities can be attached |
| Decorator          | Maintains a reference to a Component and defines an interface that conforms to Component's interface |
| ConcreteDecorator  | Adds responsibilities to the component |

```
               +-------------+
               |  Component  |
               +-------------+
               | operation() |
               +-------------+
                     ▲
          ___________|___________
         |                       |
+-------------------+    +-------------------+
| ConcreteComponent |    |     Decorator     |
+-------------------+    +-------------------+
| operation()       |    | component         |
+-------------------+    | operation()       |
                         +-------------------+
                                 ▲
                                 |
                        +-------------------+
                        | ConcreteDecorator |
                        +-------------------+
                        | operation()       |
                        | addedBehavior()   |
                        +-------------------+
```

------------------------------------------------------------

**Real World Examples:**
- Java I/O classes (FileInputStream, BufferedInputStream, etc.)
- GUI component decorators (adding scrollbars, borders to windows)
- Pizza with different toppings
- Coffee with various condiments (milk, sugar, etc.)

------------------------------------------------------------

**Standard Template (Java):**
```java
// Component interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete Components
class Margherita implements Pizza {
    public String getDescription() { return "Margherita"; }
    public double getCost() { return 7.99; }
}
class Farmhouse implements Pizza {
    public String getDescription() { return "Farmhouse"; }
    public double getCost() { return 8.99; }
}

// Decorator base class
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;
    public ToppingDecorator(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription(); }
    public double getCost() { return pizza.getCost(); }
}

// Concrete Decorators
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) { super(pizza); }
    public String getDescription() { return pizza.getDescription() + "+cheese"; }
    public double getCost() { return pizza.getCost() + 1.50; }
}
class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) { super(pizza); }
    public String getDescription() { return pizza.getDescription() + "+mushrooms"; }
    public double getCost() { return pizza.getCost() + 1.25; }
}

// Usage
Pizza pizza = new CheeseTopping(new MushroomTopping(new Margherita()));
// Result: A Margherita with mushrooms and cheese for $10.74
```

------------------------------------------------------------

**Summary Table:**

| Benefit           | Description                                               |
|-------------------|-----------------------------------------------------------|
| Flexibility       | Add responsibilities dynamically at runtime               |
| Extension         | Extend functionality without modifying existing code      |
| Composition       | Uses object composition instead of inheritance            |
| Single Responsibility | Each decorator focuses on a single additional functionality |

---

**When to Use:**
- When you need to add responsibilities to objects dynamically and transparently
- When extension by subclassing is impractical (leads to a large number of subclasses)
- When you want to add and remove responsibilities at runtime
- When you want to keep new functionality separate (Single Responsibility Principle)

---

> **Best Practice:** Keep the Component interface simple to make it easier to implement decorators. Too many methods will make the decorator hierarchy difficult to maintain.
