# A Systematic Approach to LLD Problems

This document outlines a structured, step-by-step methodology for tackling any Low-Level Design (LLD) problem. This approach ensures all requirements are met, the design is robust, and communication remains clear, especially in an interview setting.

## The 7-Step Process

Following a consistent process is key to successfully solving LLD problems.

### 1. Clarify Requirements

The first step is to ensure you have a complete and unambiguous understanding of the problem.

- **Ask Questions:** Probe for details, constraints, and scope.
- **Keep it Simple:** Focus on the core requirements first. Avoid adding unnecessary complexity.
- **Gain Confirmation:** Reiterate your understanding to the interviewer to ensure you are on the same page.

### 2. Present the "Happy Flow"

Before diving into design, outline the primary, successful user journey.

- **Walk Through:** Describe the main sequence of events from start to finish.
- **Verify Understanding:** This step confirms your interpretation of the requirements and the system's core function.

### 3. Identify Entities & Relationships

Define the core data models and how they relate to one another.

- **List Entities:** Identify all the main objects or concepts (e.g., User, Order, Product).
- **Define Properties:** List the attributes for each entity.
- **Establish Relationships:** Determine the connections between entities (e.g., a User has many Orders).
- **Plan Structure:** Sketch out the classes, including any necessary enums or constants.

### 4. Seek Design Approval

Present your high-level design before starting the implementation.

- **Review Entities:** Walk through your class and entity design.
- **Explain Logic:** Justify your design choices.
- **Get Feedback:** Ask for approval to proceed, and be prepared to make adjustments.

### 5. Implement Core Functionality

Build the working skeleton of the solution.

- **Start Simple:** Write the code for the main "happy flow."
- **Initial Concurrency:** Use thread-safe collections (ConcurrentHashMap, etc.) from the start.
- **Basic Error Handling:** Include initial null checks and essential validations as you code.

### 6. Add Robust Exception Handling

Once the core logic is in place, make the system more resilient.

- **Handle Edge Cases:** Consider what happens with invalid input or unexpected sequences.
- **Custom Exceptions:** Define and throw specific exceptions for domain-related errors (e.g., InsufficientInventoryException).

### 7. Organize into Services

Refactor the implementation into clean, focused, and independent services.

- **Single Responsibility:** Create a separate service class for each core functionality (e.g., OrderService, PaymentService, NotificationService).
- **Define Responsibilities:** For each service, list all the actions it is responsible for.
- **Maintain Decoupling:** Ensure services are independent to promote a clean and testable architecture.

## LLD Problem-Solving Template

Use this template as a starting point for any LLD problem to structure your thinking.

### Problem Statement:

### Happy Flow:
[Describe the main user journey, step-by-step.]

### Entities:
[List main entities and their properties.]

### Enums:
[List all enums and their values.]

### Services & Core Functionalities:
[List services and their primary responsibilities/methods.]

### Critical Sections:
[Identify areas that require synchronization or special handling for concurrency.]

### Exceptions:
[List custom exceptions that may be needed.]

### Utilities:
[List any helper functions or utility classes required.]

### Questions to Ask: 
[List of Questions to ask]