# Adapter Design Pattern

## Definition
Convert the interface of a class into another interface that clients expect. The **Adapter** pattern allows classes with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.

## Concept
The Adapter pattern is used when the interface of an existing class does not match the one a client needs. Instead of modifying the existing class (which might not be possible), we create an **Adapter** class that translates requests from the client into calls that are understood by the existing class.

> In essence, an Adapter wraps an existing class with a new interface so that it becomes compatible with the client.

## Structure
- **Target**: Defines the domain-specific interface used by the client.
- **Client**: Collaborates with objects conforming to the Target interface.
- **Adaptee**: An existing class with a useful behavior but incompatible interface.
- **Adapter**: Adapts the interface of the Adaptee to the Target interface.

## Note
1. The Adapter is helpful when integrating a legacy or third-party system that has a different interface than expected.
2. It promotes reusability by allowing existing functionality to work with new code without modification.
3. Two common types:
    - **Class Adapter**: Uses multiple inheritance to adapt one interface to another.
    - **Object Adapter**: Uses composition to adapt an Adaptee to the Target interface.
4. Ideal when client code cannot be changed but needs to work with different classes.
5. Makes code more flexible and easier to extend with new behaviors.

## Real World Examples
- Power plug adapters
- Integrating third-party APIs
- Legacy system integration
