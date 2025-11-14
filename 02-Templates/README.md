# Templates

Standardized templates for creating new LLD problems and design patterns. These templates ensure consistency and provide a starting point for new additions.

## 📁 Available Templates

### 🎯 Problem Template
Use this template when adding new LLD problems to maintain consistency across the repository.

**Location:** `problem-template/`

**Structure:**
```
ProblemName/
├── README.md           # Problem description and approach
├── Demo.java          # Main demo class
├── models/            # Entity classes
├── services/          # Service classes
├── constants/         # Enums and constants
└── exceptions/        # Custom exceptions
```

### 🏗️ Design Pattern Template
Use this template when adding new design patterns.

**Location:** `design-pattern-template/`

**Structure:**
```
PatternName/
├── README.md          # Pattern explanation and use cases
├── Demo.java         # Implementation demo
└── Example.java      # Real-world example
```

## 🚀 How to Use Templates

### For New Problems

1. **Copy the template:**
   ```bash
   cp -r 03-Templates/problem-template/ 04-LLD-Problems/[Difficulty]/[ProblemName]/
   ```

2. **Customize the files:**
   - Update `README.md` with problem description
   - Implement your solution in the appropriate files
   - Add your entities to `models/`
   - Add your business logic to `services/`
   - Define constants in `constants/`
   - Add custom exceptions to `exceptions/`

3. **Test your implementation:**
   ```bash
   javac *.java
   java Demo
   ```

### For New Design Patterns

1. **Copy the template:**
   ```bash
   cp -r 03-Templates/design-pattern-template/ 02-Design-Patterns/[Category]/[PatternName]/
   ```

2. **Customize the files:**
   - Update `README.md` with pattern explanation
   - Implement the pattern in `Demo.java`
   - Add real-world example in `Example.java`

## 📋 Template Guidelines

### Problem Template Guidelines

#### README.md Structure
```markdown
# Problem Name

## Problem Statement
[Clear description of what needs to be built]

## Requirements
- [List key requirements]
- [Functional requirements]
- [Non-functional requirements]

## Approach
[High-level design approach]

## Key Components
- **Models**: [List main entities]
- **Services**: [List main services]
- **Design Patterns**: [Patterns used]

## How to Run
```bash
javac *.java
java Demo
```

## Learning Outcomes
[What concepts this problem teaches]
```

#### Code Organization
- **Models**: Entity classes with properties and basic methods
- **Services**: Business logic and operations
- **Constants**: Enums, constants, and configuration
- **Exceptions**: Custom exception classes
- **Demo**: Main class demonstrating the system

### Design Pattern Template Guidelines

#### README.md Structure
```markdown
# Pattern Name

## Intent
[What the pattern does]

## Problem
[What problem it solves]

## Solution
[How it solves the problem]

## Structure
[UML diagram or description]

## Use Cases
[When to use this pattern]

## Benefits
[Advantages of using this pattern]

## Trade-offs
[Potential disadvantages]
```

## 🎯 Best Practices

### Naming Conventions
- **Classes**: PascalCase (e.g., `UserService`, `OrderItem`)
- **Methods**: camelCase (e.g., `placeOrder()`, `calculateTotal()`)
- **Variables**: camelCase (e.g., `userName`, `orderStatus`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_ORDER_ITEMS`)

### Code Quality
- Include proper comments for complex logic
- Use meaningful variable and method names
- Follow SOLID principles
- Include input validation where appropriate
- Add error handling

### Documentation
- Write clear problem statements
- Explain your approach
- Document design decisions
- Include learning outcomes
- Provide clear instructions for running the code

## 🔗 Related Resources

- [Contributing Guidelines](../CONTRIBUTING.md) - Detailed guidelines for adding new content
- [LLD Fundamentals](../03-LLD-Fundamentals/) - Essential knowledge and best practices
- [Design Patterns](../04-Design-Patterns/) - Learn about different patterns
- [SOLID Principles](../01-SOLID-Principles/) - Foundation principles for good design
