# Bridge Design Pattern

**Definition:**
A pattern that lets you split a big class or closely related set of classes into two separate hierarchies—abstraction and implementation—so they can change independently.

**Concept:**
Bridge pattern means "build a bridge" between two layers:
- One side: what you want to do (the abstraction)
- Other side: how you do it (the implementation)
You can mix and match both sides freely, making your code flexible and easy to extend.

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

**Benefits:**
- Decouples abstraction from implementation
- Both sides can be extended independently

**When to Use:**
- You want to avoid a permanent binding between abstraction and implementation
- Both abstractions and implementations should be independently extensible
