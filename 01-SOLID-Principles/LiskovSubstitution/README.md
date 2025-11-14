# Liskov Substitution Principle (LSP)

**"Objects of a superclass should be replaceable with objects of a subclass"**

## 🎯 What It Means

If you have a parent class and child classes, you should be able to use any child class wherever you use the parent class without breaking the functionality.

## 📋 Key Concepts

### Substitutability
- Child classes must be usable as parent classes
- No unexpected behavior changes
- Same interface, same behavior

### Benefits
- **Polymorphism works** - Use child classes as parent classes
- **Predictable behavior** - No surprises
- **Easy testing** - Mock with any implementation
- **Flexible design** - Interchangeable components

## 🔍 Examples

### ❌ Violation Example
```java
// BAD: Violates LSP
class Bird {
    public void fly() { /* fly logic */ }
}

class Eagle extends Bird {
    public void fly() { /* eagle fly logic */ }
}

class Penguin extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

// This breaks - can't use Penguin where Bird is expected
void makeBirdFly(Bird bird) {
    bird.fly(); // Crashes if bird is Penguin
}
```

### ✅ Correct Example
```java
// GOOD: Follows LSP
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Eagle implements Flyable {
    public void fly() { /* eagle fly logic */ }
}

class Penguin implements Swimmable {
    public void swim() { /* penguin swim logic */ }
}

// Now we can use them appropriately
void makeFlyableFly(Flyable flyable) {
    flyable.fly(); // Works for any flyable bird
}
```

## 🚀 Real-World Applications

### In LLD Problems
- **Payment Methods** - All payment methods work the same way
- **Notification Channels** - All channels send messages
- **Storage Systems** - All storage systems save/load data

### Common Patterns
- **Strategy Pattern** - Interchangeable algorithms
- **Factory Pattern** - Create objects without specifying classes
- **Observer Pattern** - All observers receive notifications

## 💡 How to Apply

1. **Design proper inheritance** - Child classes should extend parent behavior
2. **Avoid exceptions** - Don't throw exceptions in overridden methods
3. **Maintain contracts** - Same interface, same behavior
4. **Test substitution** - Verify child classes work as parent classes

## 🎯 Benefits in Practice

### Polymorphism Works
- Use child classes anywhere parent is expected
- Runtime method resolution
- Flexible object creation

### Predictable Behavior
- No unexpected exceptions
- Consistent interface
- Reliable functionality

### Easy Testing
- Mock with any implementation
- Test with different scenarios
- Verify behavior consistency

## 🔗 Related Principles

- **Open/Closed Principle** - Extend without modifying
- **Interface Segregation** - Focused interfaces
- **Dependency Inversion** - Depend on abstractions
