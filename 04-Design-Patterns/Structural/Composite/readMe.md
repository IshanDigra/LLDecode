# Composite Design Pattern

------------------------------------------------------------

**Definition:**
> The Composite Design Pattern lets you treat individual objects and groups of objects (composites) uniformly via a shared interface. It is ideal for representing part-whole hierarchies, such as tree structures, where you want to perform operations at any level.

------------------------------------------------------------

**Concept:**
> Composite solves the problem of managing tree-like or nested structures, where objects can be both containers (composites) and leaves (individual items). By defining a common interface for both, you can build flexible, scalable systems where operations (like turnOn/turnOff) apply to any level of the hierarchy without special-case logic.

------------------------------------------------------------

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



------------------------------------------------------------

**Real World Examples:**
- **File Systems:** Directories (composites) contain files or other directories; files are leaves.
- **GUI Frameworks:** Panels (composites) contain buttons, labels, or other panels.
- **Organization Hierarchies:** Departments (composites) contain employees (leaves) or sub-departments.

------------------------------------------------------------

**Code Example (Generalized Template):**
```java
// Component interface
interface SmartComponent {
    void operation();
}
// Leaf
class AirConditioner implements SmartComponent {
    public void operation() {
        System.out.println("Air Conditioner is now ON.");
    }
}
class SmartLight implements SmartComponent {
    public void operation() {
        System.out.println("Smart Light is now ON.");
    }
}
// Composite
class CompositeSmartComponent implements SmartComponent {
    private List<SmartComponent> components = new ArrayList<>();
    public void addComponent(SmartComponent component) { components.add(component); }
    public void removeComponent(SmartComponent component) { components.remove(component); }
    public void operation() {
        for (SmartComponent c : components) c.operation();
    }
}
```
> **Note:** Replace `operation()` with your actual method (e.g., turnOn/turnOff, display, etc.) and rename classes for your use case.

------------------------------------------------------------

**Usage:**
```java
public class SmartHomeController {
    public static void main(String[] args) {
        SmartComponent ac = new AirConditioner();
        SmartComponent light = new SmartLight();
        CompositeSmartComponent room = new CompositeSmartComponent();
        room.addComponent(ac);
        room.addComponent(light);
        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(room);
        System.out.println("Turning ON all devices in the house:");
        house.turnOn();
        System.out.println("Turning OFF all devices in the house:");
        house.turnOff();
    }
}
```

------------------------------------------------------------

**Summary:**

| Benefit | Description |
|---------|-------------|
| **Uniformity**  | Treats individual objects and groups uniformly via a shared interface |
| **Scalability** | Easily add new component types or restructure the hierarchy |
| **Decoupling**  | Client code is decoupled from specific structure, improving modularity |
| **Flexibility** | Great for tree-like data (file systems, GUIs, organizations, etc.) |
| **Caveat**      | Can make system design more complex if the hierarchy is not needed |

> **Key Point:** Composite is essential for building systems where hierarchies are a natural fit, ensuring flexibility and reducing complexity.

------------------------------------------------------------
