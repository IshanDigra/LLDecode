# Structural Design Patterns

---

## Introduction

Structural design patterns explain how to assemble objects and classes into larger structures. Like an architect working with engineers and contractors to build a skyscraper, these patterns help you organize components so they fit together cleanly, stay flexible, and remain easy to maintain.

---

## Why “Structural”?

The word "structural" refers to how parts are arranged into a whole. Just as beams, walls, and floors form a stable building, structural patterns define blueprints for how objects and classes should connect and collaborate.

---

## The Problem

In a large application, you may have many components—APIs, databases, user interfaces—that need to work together. Without clear guidelines, dependencies become tangled. A small change can break multiple parts of the system.

Structural patterns provide clear, reusable ways to link components. This reduces direct dependencies and makes your system easier to understand, extend, and maintain.

---

## Common Structural Patterns

| Pattern    | What it Does                                                                              | Analogy                                                         | Use Case                                                      |
|------------|-------------------------------------------------------------------------------------------|------------------------------------------------------------------|---------------------------------------------------------------|
| **Adapter**    | Lets incompatible interfaces work together by wrapping one object in another.               | Using a power plug adapter when traveling to a country with different outlets. | Integrating a third-party API with a different data format.    |
| **Bridge**     | Separates an abstraction from its implementation so both can vary independently.           | A suspension bridge where the deck and cables are designed separately.         | Cross-platform UI framework with different rendering back ends.|
| **Composite**  | Treats individual objects and groups of objects uniformly under a common interface.        | Treating a tree’s leaves and branches the same for total weight.              | File system where files and folders implement the same interface.|
| **Decorator**  | Adds behavior to an object dynamically by wrapping it in a decorator class.                | Decorating a plain cake with layers of frosting and toppings.                 | Adding spell-check or auto-format to a text editor.           |
| **Facade**     | Provides a simple interface to a complex subsystem.                                       | Pressing a single button to turn on all devices in a smart home.              | Database façade with connect, query, and disconnect methods.  |
| **Flyweight**  | Shares common parts of objects to reduce memory usage.                                    | A library sharing one copy of each book title among many readers.             | Text rendering that reuses glyph objects for repeated chars.  |
| **Proxy**      | Controls access to another object, adding a layer of indirection.                         | A personal assistant who handles calls and appointments for you.              | Image proxy that loads large images only when needed.         |

---

## When to Use Structural Patterns

- **Reduce Complexity**  
  Hide detailed relationships behind a simple interface.

- **Promote Reuse**  
  Combine existing components in new ways without duplication.

- **Maintain Flexibility**  
  Change or replace parts of the structure without rewriting everything else.

- **Improve Performance**  
  Share resources and delay heavy operations until needed.

---

## Conclusion

> Structural design patterns are the architects of your codebase. They guide how objects and classes fit together, ensuring your software remains organized, scalable, and easy to maintain—just like a well-designed building stands strong and adaptable over time.
