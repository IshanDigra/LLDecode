# Builder Design Pattern

------------------------------------------------------------

**Definition:**  
The Builder pattern suggests that you extract the object con-
struction code out of its own class and move it to separate
objects called builders.

------------------------------------------------------------

**Concept:**  
The Builder pattern constructs complex objects step by step. It enables the creation of different representations of an object using the same construction process, isolating the construction logic from the object itself. This is useful when an object requires numerous configuration options or assembly steps.

---

**Analogy:**  
Think of building a meal at a restaurant. You (the Director) instruct the chef (the Builder) step by step—choose a drink, main course, dessert, etc. The chef follows your instructions to assemble the meal, but you can ask for different combinations each time.

> **Note:** The Builder pattern is ideal when object creation is complex or involves many optional parts. It keeps construction code separate from the product.



---

**Structure:**

| Participant        | Role                                                        |
|--------------------|-------------------------------------------------------------|
| Builder (Interface)| Specifies steps to build parts of the Product               |
| ConcreteBuilder    | Implements steps to assemble the product                    |
| Director           | Constructs the object using the Builder interface           |
| Product            | The complex object being built                              |

```
+-----------+        +-------------------+        +-------------------+
|  Director | -----> |     Builder       | <----- | ConcreteBuilder   |
+-----------+        +-------------------+        +-------------------+
                                         |
                                         v
                                   +-----------+
                                   |  Product  |
                                   +-----------+
```

------------------------------------------------------------

**Real World Examples:**
- Building a house: Foundation, walls, roof, etc., constructed step by step.
- Assembling a computer: Adding CPU, RAM, storage, etc.
- Creating a meal: Appetizer, main course, dessert, etc.

------------------------------------------------------------


**Standard Template (Java):**
```java
// Product class - holds the complex object being built
class Meal {
    private String drink, mainCourse, dessert;
    // Setters omitted for brevity
}
// Builder interface - defines all possible construction steps
interface MealBuilder {
    MealBuilder setDrink(String drink);     // Methods to set each part
    MealBuilder setMainCourse(String mainCourse);
    MealBuilder setDessert(String dessert);
    Meal build();                           // Method to retrieve the final product
}

// Concrete Builder - implements the construction steps
class VegMealBuilder implements MealBuilder {
    private Meal meal; 
    // constructor to initialize meal with some default vegan meal
    public VegMealBuilder() {
        meal = new Meal();
        meal.setDrink("Juice");
        meal.setMainCourse("Paneer Curry");
        meal.setDessert("Gulab Jamun");
    }
    public MealBuilder setDrink(String drink) { meal.setDrink(drink); return this; }
    public MealBuilder setMainCourse(String mainCourse) { meal.setMainCourse(mainCourse); return this; }
    public MealBuilder setDessert(String dessert) { meal.setDessert(dessert); return this; }
    public Meal build() { return meal; }
}

// Usage
MealBuilder builder = new VegMealBuilder();
Meal meal = builder.setDrink("Coffee").setMainCourse("Curry").build();
```

---


**Summary Table:**

| Benefit           | Description                                               |
|-------------------|-----------------------------------------------------------|
| Step-by-step      | Allows construction process to be controlled stepwise     |
| Flexibility       | Different representations with the same construction code |
| Readability       | Construction logic is separated from product logic        |
| Maintainability   | Easy to add new steps or products                        |

---

**When to Use:**
- When an object needs to be created with many configuration options
- When the construction process must allow different representations
- When you want to isolate complex construction logic from the product

---
