# Bridge Design Pattern

------------------------------------------------------------

**Definition:**
A pattern that lets you split a big class or closely related set of classes into two separate hierarchies—abstraction and implementation—so they can change independently.

------------------------------------------------------------

**Concept:**
Bridge pattern means "build a bridge" between two layers:
- One side: what you want to do (the abstraction)
- Other side: how you do it (the implementation)
  You can mix and match both sides freely, making your code flexible and easy to extend.

------------------------------------------------------------

**Structure:**

| **Role**                | **Example**             |
|-------------------------|------------------------|
| Abstraction             | Animal                 |
| Implementation          | MoveLogic              |
| Refined Abstraction     | Person, Bird, Fish     |
| Concrete Implementation | Walk, Swim, Fly        |

**Diagram (Showing the Bridge):**
```
+-------------------+           holds reference to           +----------------------+
|    Animal         |  ----------------------------------->  |     MoveLogic        |
|  (Abstraction)    |             (the "bridge")             |  (Implementation)    |
+-------------------+                                        +----------------------+
         |                                                        ^
         | delegates move()                                       |
         +--------------------------------------------------------+

Example: Person, Fish, Bird    <---bridge--->   Walk, Swim, Fly
```
> The bridge: Animal classes hold a MoveLogic and delegate their move() action to it, allowing both sides to vary independently.
---
**Why Delegate Move Logic?**
- If each animal (Person, Monkey, etc.) implemented its own `move` logic, you'd end up duplicating code for common behaviors (like walking).
- By delegating to `MoveLogic`, you can share the same behavior across multiple animals. For example, both `Person` and `Monkey` can use the same `Walk` logic—no copy-paste required!
- This makes your code DRY (Don't Repeat Yourself), easier to maintain, and flexible to extend with new animals or movement types.

------------------------------------------------------------

**Real World Examples:**
- Remote controls (abstraction) and devices (implementation)
- Drawing shapes (abstraction) with different graphics APIs (implementation)
- Animals (abstraction) and how they move (implementation)

------------------------------------------------------------

**Code Example (Generalized with Interfaces):**
```java
// MoveLogic interface (Implementor)
interface MoveLogic {
  void move();
}
// Concrete MoveLogics
class Walk implements MoveLogic {
  public void move() { System.out.println("Walking"); }
}
class Swim implements MoveLogic {
  public void move() { System.out.println("Swimming"); }
}
class Fly implements MoveLogic {
  public void move() { System.out.println("Flying"); }
}

// Animal interface (Abstraction)
interface Animal {
  void move();
}
// Concrete Animals (RefinedAbstraction)
class Person implements Animal {
  private MoveLogic moveLogic;
  public Person(MoveLogic moveLogic) { this.moveLogic = moveLogic; }
  public void move() { moveLogic.move(); }
}
class Fish implements Animal {
  private MoveLogic moveLogic;
  public Fish(MoveLogic moveLogic) { this.moveLogic = moveLogic; }
  public void move() { moveLogic.move(); }
}
class Bird implements Animal {
  private MoveLogic moveLogic;
  public Bird(MoveLogic moveLogic) { this.moveLogic = moveLogic; }
  public void move() { moveLogic.move(); }
}
  // Usage
  Animal person = new Person(new Walk());
person.move(); // Output: Walking
        Animal fish = new Fish(new Swim());
        fish.move();   // Output: Swimming
        Animal bird = new Bird(new Fly());
        bird.move();   // Output: Flying
```

------------------------------------------------------------

**Bridge vs. Strategy Pattern**

| Aspect         | Bridge Pattern                                              | Strategy Pattern                                   |
|----------------|------------------------------------------------------------|----------------------------------------------------|
| **Intent**     | Decouple abstraction from implementation so both can vary independently | Make algorithms interchangeable at runtime         |
| **Structure**  | Two class hierarchies: Abstraction ↔ Implementation       | Context delegates to a Strategy interface          |
| **When to Use**| When you want to avoid a combinatorial explosion of subclasses and allow both the abstraction and implementation to be extended independently | When you want to change the behavior (algorithm) of an object dynamically |
| **Example**    | `Animal` delegates movement to `MoveLogic` (`Walk`, `Fly`) | `Duck` switches between different `FlyBehavior`s   |
| **Key Focus**  | Flexibility in abstraction and implementation hierarchies  | Flexibility in choosing an algorithm               |

> **Note:**  
> The code structure can look similar, but the design intent is different. Bridge is about separating what you do from how you do it; Strategy is about choosing how you do something from a set of options.

------------------------------------------------------------

**Summary:**
- Split big things into two smaller, independent parts
- Change what you do and how you do it separately
- Great for flexibility and reducing code duplication

------------------------------------------------------------
