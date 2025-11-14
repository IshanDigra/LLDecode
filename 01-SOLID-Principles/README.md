# SOLID Principles

The foundation of good object-oriented design. These five principles guide you in creating maintainable, flexible, and robust software systems.

## 🎯 Learning Objectives

After studying these principles, you will understand:
- How to design maintainable code
- When to apply each principle
- How to refactor code to follow SOLID
- The benefits of good design
- Common design anti-patterns

## 📋 Principles

### Single Responsibility Principle (SRP)
**"A class should have only one reason to change"**

- **Focus:** One responsibility per class
- **Benefits:** Easier testing, maintenance, and understanding
- **Examples:** User management, email sending, data validation

### Open/Closed Principle (OCP)
**"Software entities should be open for extension, but closed for modification"**

- **Focus:** Extensibility without modification
- **Benefits:** Stable core, flexible extensions
- **Examples:** Plugin systems, strategy patterns

### Liskov Substitution Principle (LSP)
**"Objects of a superclass should be replaceable with objects of a subclass"**

- **Focus:** Proper inheritance relationships
- **Benefits:** Polymorphism works correctly
- **Examples:** Shape hierarchies, payment methods

### Interface Segregation Principle (ISP)
**"Clients should not be forced to depend on interfaces they don't use"**

- **Focus:** Focused, cohesive interfaces
- **Benefits:** Loose coupling, easier implementation
- **Examples:** Role-based interfaces, feature-specific APIs

### Dependency Inversion Principle (DIP)
**"Depend on abstractions, not concretions"**

- **Focus:** Dependency on interfaces, not implementations
- **Benefits:** Flexible, testable, maintainable
- **Examples:** Dependency injection, service layers

## 🚀 Learning Path

1. **Start with SRP** - Understand single responsibility
2. **Learn OCP** - Design for extension
3. **Master LSP** - Proper inheritance
4. **Apply ISP** - Focused interfaces
5. **Use DIP** - Dependency management

## 💡 Key Benefits

### Maintainability
- Easy to understand and modify
- Clear separation of concerns
- Reduced complexity

### Testability
- Easy to unit test
- Mock dependencies
- Isolated components

### Flexibility
- Easy to extend
- Loose coupling
- Configurable behavior

### Reusability
- Components can be reused
- Generic interfaces
- Modular design

## 🔗 Real-World Applications

### In LLD Problems
- **Parking Lot** - SRP for different responsibilities
- **Vending Machine** - OCP for payment methods
- **E-commerce** - DIP for payment processing

### In Design Patterns
- **Strategy Pattern** - OCP and DIP
- **Observer Pattern** - DIP and ISP
- **Factory Pattern** - DIP and SRP

## 🎯 Common Violations

### SRP Violations
- God classes with multiple responsibilities
- Classes that change for different reasons
- Mixed concerns in single class

### OCP Violations
- Modifying existing code for new features
- Switch statements for type checking
- Hard-coded behavior

### LSP Violations
- Subclasses that can't replace parent
- Throwing exceptions in overridden methods
- Changing behavior in subclasses

### ISP Violations
- Fat interfaces with unused methods
- Forcing clients to implement unused methods
- Interface pollution

### DIP Violations
- Depending on concrete classes
- Hard-coded dependencies
- Tight coupling

## 🔗 Next Steps

After mastering SOLID principles, move on to:
- [Design Patterns](../02-Design-Patterns/) - Apply principles in patterns
- [LLD Problems](../04-LLD-Problems/) - Use principles in real problems
- [Templates](../03-Templates/) - Create SOLID-compliant code
