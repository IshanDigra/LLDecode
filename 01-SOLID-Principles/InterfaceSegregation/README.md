# Interface Segregation Principle (ISP)

**"Clients should not be forced to depend on interfaces they don't use"**

## 🎯 What It Means

Don't create fat interfaces with methods that clients don't need. Instead, create focused, cohesive interfaces that clients actually use.

## 📋 Key Concepts

### Focused Interfaces
- One interface = One responsibility
- Only methods clients need
- Cohesive functionality

### Benefits
- **Loose coupling** - Clients depend only on what they use
- **Easier implementation** - Don't implement unused methods
- **Better design** - Forces focused interfaces
- **Flexible composition** - Mix and match interfaces

## 🔍 Examples

### ❌ Violation Example
```java
// BAD: Fat interface with unused methods
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker {
    public void work() { /* robot work */ }
    public void eat() { /* robots don't eat! */ }
    public void sleep() { /* robots don't sleep! */ }
}

class Human implements Worker {
    public void work() { /* human work */ }
    public void eat() { /* human eat */ }
    public void sleep() { /* human sleep */ }
}
```

### ✅ Correct Example
```java
// GOOD: Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

class Robot implements Workable {
    public void work() { /* robot work */ }
}

class Human implements Workable, Eatable, Sleepable {
    public void work() { /* human work */ }
    public void eat() { /* human eat */ }
    public void sleep() { /* human sleep */ }
}
```

## 🚀 Real-World Applications

### In LLD Problems
- **User Systems** - Separate authentication from profile management
- **Payment Systems** - Separate payment from refund operations
- **Notification Systems** - Separate different notification types

### Common Patterns
- **Role-Based Interfaces** - Different roles, different interfaces
- **Feature-Specific APIs** - Focused functionality
- **Plugin Systems** - Minimal required interfaces

## 💡 How to Apply

1. **Identify client needs** - What methods do clients actually use?
2. **Split fat interfaces** - Separate different responsibilities
3. **Keep related methods** - Don't over-split
4. **Design for composition** - Mix and match interfaces

## 🎯 Benefits in Practice

### Loose Coupling
- Clients depend only on what they use
- Easy to change implementations
- Flexible system design

### Easier Implementation
- Don't implement unused methods
- Focus on required functionality
- Cleaner code

### Better Design
- Forces focused interfaces
- Promotes single responsibility
- Enables flexible composition

## 🔗 Related Principles

- **Single Responsibility** - One responsibility per interface
- **Dependency Inversion** - Depend on focused abstractions
- **Open/Closed** - Extend with new interfaces
