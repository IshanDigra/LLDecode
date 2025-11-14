# Dependency Inversion Principle (DIP)

**"Depend on abstractions, not concretions"**

## 🎯 What It Means

High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

## 📋 Key Concepts

### Depend on Abstractions
- Use interfaces and abstract classes
- Don't depend on concrete implementations
- Invert the dependency direction

### Benefits
- **Flexible design** - Easy to change implementations
- **Testable code** - Easy to mock dependencies
- **Loose coupling** - Modules are independent
- **Reusable components** - Use different implementations

## 🔍 Examples

### ❌ Violation Example
```java
// BAD: Depends on concrete classes
class EmailService {
    public void sendEmail(String message) { /* email logic */ }
}

class NotificationService {
    private EmailService emailService; // Depends on concrete class
    
    public NotificationService() {
        this.emailService = new EmailService(); // Hard-coded dependency
    }
    
    public void sendNotification(String message) {
        emailService.sendEmail(message);
    }
}
```

### ✅ Correct Example
```java
// GOOD: Depends on abstraction
interface NotificationChannel {
    void send(String message);
}

class EmailService implements NotificationChannel {
    public void send(String message) { /* email logic */ }
}

class SMSService implements NotificationChannel {
    public void send(String message) { /* SMS logic */ }
}

class NotificationService {
    private NotificationChannel channel; // Depends on abstraction
    
    public NotificationService(NotificationChannel channel) {
        this.channel = channel; // Injected dependency
    }
    
    public void sendNotification(String message) {
        channel.send(message);
    }
}
```

## 🚀 Real-World Applications

### In LLD Problems
- **Payment Systems** - Depend on payment interfaces, not specific payment methods
- **Storage Systems** - Depend on storage interfaces, not specific databases
- **Notification Systems** - Depend on notification interfaces, not specific channels

### Common Patterns
- **Dependency Injection** - Inject dependencies from outside
- **Factory Pattern** - Create objects without specifying classes
- **Strategy Pattern** - Interchangeable algorithms

## 💡 How to Apply

1. **Identify dependencies** - What does your class depend on?
2. **Create abstractions** - Define interfaces for dependencies
3. **Inject dependencies** - Don't create dependencies inside classes
4. **Use factories** - Create objects through factories

## 🎯 Benefits in Practice

### Flexible Design
- Easy to change implementations
- Plugin-like architecture
- Configurable behavior

### Testable Code
- Easy to mock dependencies
- Isolated unit testing
- Controlled test scenarios

### Loose Coupling
- Modules are independent
- Easy to reuse components
- Flexible system design

## 🔗 Related Principles

- **Open/Closed Principle** - Extend without modifying
- **Interface Segregation** - Focused interfaces
- **Single Responsibility** - Focused dependencies
