# Composite Design Pattern

**Definition:**
The Composite Design Pattern lets you treat individual objects and groups of objects (composites) uniformly via a shared interface. It is ideal for representing part-whole hierarchies, such as tree structures, where you want to perform operations at any level.

**Concept:**
Composite solves the problem of managing tree-like or nested structures, where objects can be both containers (composites) and leaves (individual items). By defining a common interface for both, you can build flexible, scalable systems where operations (like turnOn/turnOff) apply to any level of the hierarchy without special-case logic.

**Structure:**
| Participant | Description |
|-------------|-------------|
| **Component** | The common interface for all objects in the hierarchy (e.g., `SmartComponent`). |
| **Leaf**      | Represents individual objects (e.g., `AirConditioner`, `SmartLight`) that implement the component interface. |
| **Composite** | Represents groups (e.g., `Room`, `Floor`, `House`) that can hold child components (leaves or other composites) and delegate operations to them. |

**Visual Example:**
```
House (Composite)
  └── Floor (Composite)
        ├── Room 1 (Composite)
        │     ├── AirConditioner (Leaf)
        │     └── SmartLight (Leaf)
        └── Room 2 (Composite)
              ├── AirConditioner (Leaf)
              └── SmartLight (Leaf)
```

**Real World Examples:**
- File Systems: Directories (composites) contain files or other directories; files are leaves.
- GUI Frameworks: Panels (composites) contain buttons, labels, or other panels.

**Benefits:**
- Simplifies client code
- Makes it easy to add new types of components

**When to Use:**
- You want to represent part-whole hierarchies
- You want clients to treat individual objects and groups uniformly
