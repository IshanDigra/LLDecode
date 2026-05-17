# Decorator Design Pattern

**Definition:**
Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

**Concept:**
The Decorator pattern allows behavior to be added to individual objects without affecting the behavior of other objects from the same class. It follows the Open/Closed principle by allowing functionality to be extended without modifying existing code.

**Analogy:**
Think of a pizza shop. You start with a basic pizza (Margherita or Farmhouse) and then add various toppings (cheese, mushrooms, salami). Instead of creating a separate class for each possible pizza-topping combination (which would lead to class explosion), you "decorate" the base pizza with toppings.

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
```

**Benefits:**
- Flexible alternative to subclassing
- Can add or remove responsibilities at runtime

**When to Use:**
- You want to add responsibilities to objects without affecting others
- You want to add responsibilities dynamically
