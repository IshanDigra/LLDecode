# Contributing to LLD Compilation

Thank you for contributing to this LLD learning repository! This guide will help you add new problems and maintain consistency.

## 📋 Guidelines for Adding New Problems

### 1. Problem Structure
Use the template in `03-Templates/problem-template/` as your starting point:

```
ProblemName/
├── README.md           # Problem description and approach
├── Demo.java          # Main demo class
├── models/            # Entity classes
├── services/          # Service classes
├── constants/         # Enums and constants
└── exceptions/        # Custom exceptions
```

### 2. README.md Template
Each problem should have a comprehensive README.md:

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

### 3. Code Standards

#### Naming Conventions
- **Classes**: PascalCase (e.g., `UserService`, `OrderItem`)
- **Methods**: camelCase (e.g., `placeOrder()`, `calculateTotal()`)
- **Variables**: camelCase (e.g., `userName`, `orderStatus`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_ORDER_ITEMS`)

#### File Organization
- **Models**: Entity classes in `models/` folder
- **Services**: Business logic in `services/` folder
- **Constants**: Enums and constants in `constants/` folder
- **Exceptions**: Custom exceptions in `exceptions/` folder

#### Code Quality
- Include proper comments for complex logic
- Use meaningful variable and method names
- Follow SOLID principles
- Include input validation where appropriate

### 4. Difficulty Categorization

#### Beginner (01-Beginner)
- 2-3 core entities
- Basic CRUD operations
- Single responsibility focus
- No complex business logic

#### Easy (02-Easy)
- 3-5 core entities
- Basic state management
- 1-2 design patterns
- Simple business rules

#### Medium (03-Medium)
- 5-8 core entities
- Multiple interacting services
- State management complexity
- 2-3 design patterns
- Some concurrency considerations

#### Hard (04-Hard)
- 8+ core entities
- Complex business logic
- Multiple service layers
- 3+ design patterns
- Payment/transaction handling

#### Expert (05-Expert)
- Enterprise-level complexity
- Scalability considerations
- Advanced design patterns
- Complex algorithms
- Real-world system constraints

### 5. Adding Design Patterns

Use the template in `03-Templates/design-pattern-template/`:

```
PatternName/
├── README.md          # Pattern explanation and use cases
├── Demo.java         # Implementation demo
├── Example.java      # Real-world example
└── Theory.md         # Detailed theory (optional)
```

### 6. Testing Your Addition

Before submitting:
- [ ] Code compiles without errors
- [ ] Demo runs successfully
- [ ] README.md is complete and clear
- [ ] Follows naming conventions
- [ ] Appropriate difficulty level
- [ ] Includes learning outcomes

### 7. Submission Process

1. Create your problem in the appropriate difficulty folder
2. Follow the template structure
3. Test thoroughly
4. Update the difficulty folder's README.md to include your problem
5. Submit with a clear description of what you've added

## 🎯 Best Practices

### Problem Design
- Start with clear requirements
- Think about real-world usage
- Consider edge cases
- Design for extensibility

### Code Organization
- Separate concerns (models, services, constants)
- Use appropriate design patterns
- Write clean, readable code
- Include proper error handling

### Documentation
- Write clear problem statements
- Explain your approach
- Document design decisions
- Include learning outcomes

## 🚫 What Not to Do

- Don't copy solutions from other repositories without attribution
- Don't submit incomplete implementations
- Don't ignore the template structure
- Don't place problems in wrong difficulty levels
- Don't skip documentation

## 📞 Getting Help

If you need help or have questions:
- Check existing problems for examples
- Review the templates for structure
- Ask specific questions about implementation

Thank you for contributing to the LLD learning community! 🚀
