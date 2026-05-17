# Facade Design Pattern

**Definition:**
Provides a unified, simplified interface to a set of complex subsystems, making the system easier to use and decoupling the client from subsystem details.

**Concept:**
The facade pattern introduces a single entry point (the facade) that handles interactions with multiple subsystems. Clients use the facade instead of interacting with each subsystem directly, reducing complexity and dependency.

**Structure:**
| **Role**   | **Description / Example**                              |
|:-----------|:------------------------------------------------------|
| **Facade** | Provides a unified, simple interface (e.g., MediaFacade) |
| **Subsystem(s)** | Complex components that do the actual work (e.g., MusicPlayer, VideoPlayer, ImageViewer) |
| **Client** | Uses the facade to interact with the system (e.g., MultimediaApp) |

**Visual Overview:**
```
   +---------+           +-------------------+
   |  Client |---------> |     Facade        |
   +---------+           +-------------------+
                                |     |     |
                                v     v     v
                        +--------+ +--------+ +---------+
                        |MusicPlr| |VideoPlr| |ImageVwr|
                        +--------+ +--------+ +---------+
```

**Benefits:**
- Simplifies usage of complex systems
- Reduces dependencies between client and subsystems

**When to Use:**
- You want to provide a simple interface to a complex system
- You want to decouple clients from subsystem implementation
