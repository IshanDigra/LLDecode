# Open/Closed Principle (OCP)

**"Software entities should be open for extension, but closed for modification"**

## 🎯 What It Means

You should be able to add new functionality without changing existing code. The system should be open for extension but closed for modification.

## 📋 Key Concepts

### Open for Extension
- Add new features easily
- Extend behavior without changing core
- Plugin-like architecture

### Closed for Modification
- Don't change existing code
- Stable core functionality
- Reduce risk of breaking changes

### Benefits
- **Stable core** - Existing code doesn't change
- **Easy extension** - Add new features
- **Reduced risk** - Less chance of bugs
- **Better design** - Forces good architecture

## 🔍 Examples

### ❌ Violation Example
```java
// BAD: Modifying existing code for new features
class PaymentProcessor {
    public void processPayment(String type, double amount) {
        if (type.equals("credit")) {
            // Credit card logic
        } else if (type.equals("debit")) {
            // Debit card logic
        } else if (type.equals("paypal")) {
            // PayPal logic
        }
        // Adding new payment method requires modifying this method
    }
}
```

### ✅ Correct Example
```java
// GOOD: Open for extension, closed for modification
interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) { /* credit logic */ }
}

class DebitCardPayment implements PaymentMethod {
    public void processPayment(double amount) { /* debit logic */ }
}

class PayPalPayment implements PaymentMethod {
    public void processPayment(double amount) { /* paypal logic */ }
}

class PaymentProcessor {
    public void processPayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}
```

## 🚀 Real-World Applications

### In LLD Problems
- **Payment Systems** - Add new payment methods
- **Notification Systems** - Add new notification channels
- **Storage Systems** - Add new storage backends

### Common Patterns
- **Strategy Pattern** - Interchangeable algorithms
- **Factory Pattern** - Create objects without specifying classes
- **Observer Pattern** - Add new observers

## 💡 How to Apply

1. **Identify extension points** - Where might you need new features?
2. **Use abstractions** - Interfaces and abstract classes
3. **Design for change** - Anticipate future requirements
4. **Keep core stable** - Don't modify existing functionality

## 🎯 Benefits in Practice

### Easy Feature Addition
- Add new functionality without risk
- Plugin-like architecture
- Flexible system design

### Reduced Risk
- Existing code stays stable
- Less chance of introducing bugs
- Safer development process

### Better Architecture
- Forces good design decisions
- Promotes loose coupling
- Enables team collaboration

## 🔗 Related Principles

- **Liskov Substitution** - Proper inheritance
- **Dependency Inversion** - Depend on abstractions
- **Interface Segregation** - Focused interfaces
