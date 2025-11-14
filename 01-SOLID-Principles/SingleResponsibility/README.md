# Single Responsibility Principle (SRP)

**"A class should have only one reason to change"**

## 🎯 What It Means

Each class should have only one job or responsibility. If a class has multiple reasons to change, it violates SRP and should be split into multiple classes.

## 📋 Key Concepts

### Single Responsibility
- One class = One responsibility
- One reason to change
- Clear, focused purpose

### Benefits
- **Easier to understand** - Clear purpose
- **Easier to test** - Focused testing
- **Easier to maintain** - Isolated changes
- **Easier to reuse** - Focused functionality

## 🔍 Examples

### ❌ Violation Example
```java
// BAD: Multiple responsibilities
class User {
    private String name;
    private String email;
    
    // User management
    public void save() { /* database logic */ }
    public void delete() { /* database logic */ }
    
    // Email sending
    public void sendEmail(String message) { /* email logic */ }
    
    // Validation
    public boolean isValid() { /* validation logic */ }
}
```

### ✅ Correct Example
```java
// GOOD: Single responsibility
class User {
    private String name;
    private String email;
    
    // Only user data
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class UserRepository {
    public void save(User user) { /* database logic */ }
    public void delete(User user) { /* database logic */ }
}

class EmailService {
    public void sendEmail(User user, String message) { /* email logic */ }
}

class UserValidator {
    public boolean isValid(User user) { /* validation logic */ }
}
```

## 🚀 Real-World Applications

### In LLD Problems
- **User Management** - Separate user data from user operations
- **Order Processing** - Separate order creation from payment processing
- **Inventory Management** - Separate inventory data from inventory operations

### Common Patterns
- **Repository Pattern** - Data access responsibility
- **Service Pattern** - Business logic responsibility
- **Validator Pattern** - Validation responsibility

## 💡 How to Apply

1. **Identify responsibilities** - What does the class do?
2. **Find change reasons** - Why might it change?
3. **Split if needed** - Separate different responsibilities
4. **Keep related** - Don't over-split

## 🎯 Benefits in Practice

### Easier Testing
- Test one responsibility at a time
- Mock dependencies easily
- Clear test boundaries

### Easier Maintenance
- Changes are isolated
- Less risk of breaking other functionality
- Clear ownership

### Better Reusability
- Use components independently
- Mix and match functionality
- Flexible composition

## 🔗 Related Principles

- **Open/Closed Principle** - Extend without modifying
- **Dependency Inversion** - Depend on abstractions
- **Interface Segregation** - Focused interfaces
