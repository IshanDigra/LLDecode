# Mediator Design Pattern

---

## Definition

The Mediator pattern defines an object that controls how a group of objects interact. Instead of talking to each other directly, objects send messages to the mediator, which forwards them as needed. This keeps objects loosely connected and easier to manage.

---

## Concept

- **Mediator**: Acts as a central hub for communication.
- **Colleagues**: Objects that talk only to the mediator, not to each other.
- When one object needs to send a message, it asks the mediator.
- The mediator decides which objects should receive that message and forwards it.

---

## Benefits

- **Simpler Communication**  
  Turns many-to-many interactions into one-to-many through the mediator.

- **Loose Coupling**  
  Colleagues depend only on the mediator, not on each other’s details.

- **Central Control**  
  Changing how objects interact happens in one place.

- **Easier Maintenance**  
  You can add, remove, or modify colleagues without touching their peers.

---

## Real-World Examples

- **Air Traffic Control**  
  Planes report to the control tower, which coordinates takeoffs and landings.

- **Chat Room**  
  Users send messages to a server that distributes them to everyone in the room.

- **GUI Dialog Manager**  
  Window components talk to a dialog controller, which updates other components.

---

## Mediator vs Observer

| Aspect             | Observer                                   | Mediator                                             |
|--------------------|--------------------------------------------|------------------------------------------------------|
| **Communication**  | One-to-many: subject notifies observers    | Many-to-many via a central mediator                  |
| **Coupling**       | Observers know about the subject           | Colleagues know only the mediator, not each other    |
| **Use Case**       | Event broadcasting or change notification  | Complex workflows where many objects coordinate      |

---
