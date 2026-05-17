# Abstract Factory Pattern

---

## Definition
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

---

## Concept & Analogy
The Abstract Factory pattern lets you produce families of related objects without exposing their concrete classes. Imagine a furniture store that supplies entire sets—Victorian or Modern. You order a set, and the store provides a matching chair, sofa, and coffee table in the same style. You don’t need to know how each piece is made; the store (factory) handles it all.

---

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
|ModernFurnitureFact.|    |VictorianFurnitureFact. |
+---------------------+    +------------------------+

```

**Benefits:**
- Consistency: Ensures products from the same family are used together
- Flexibility: Easy to switch product families at runtime
- Scalability: Adding new product families is straightforward

**When to Use:**
- Your code needs to work with various families of related products
- You want to enforce product compatibility
- You want to avoid hard-coding product classes
