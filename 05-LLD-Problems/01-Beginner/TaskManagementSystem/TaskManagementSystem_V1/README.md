# Task Management System

## Overview

A multi-user task management system with assignment, prioritization, deadline tracking, and automated reminders. Built using Singleton pattern with thread-safe operations.

## Problem Statement

The task management system should allow users to create, update, and delete tasks.
Each task should have a title, description, due date, priority, and status (e.g., pending, in progress, completed).
Users should be able to assign tasks to other users and set reminders for tasks.
The system should support searching and filtering tasks based on various criteria (e.g., priority, due date, assigned user).
Users should be able to mark tasks as completed and view their task history.
The system should handle concurrent access to tasks and ensure data consistency.
The system should be extensible to accommodate future enhancements and new features.

## Core Entities

| Entity | Key Properties | Key Methods |
|--------|---------------|-------------|
| **Task** | id, title, description, dueDate, priority, status, assignedBy, assignedTo | setPriority(), setStatus(), setAssignedTo() |
| **User** | id, name | setName() |
| **TaskManager** | userTasksMapping, taskList, reminderService | createTask(), updateTask(), deleteTask(), assignTask(), searchTask(), filterTask() |
| **ReminderService** | - | scheduleReminder(), sendReminder() |

## Enums

| Enum | Values | Purpose |
|------|--------|---------|
| **TaskPriority** | LOW, MEDIUM, HIGH | Define task priority levels |
| **TaskStatus** | ACTIVE, COMPLETED, DELETED | Track task lifecycle state |

## Core Functionalities

### CRUD Operations
- **Create**: Generate new task with title, description, due date, and priority
- **Update**: Modify task properties including reassignment
- **Delete**: Remove task from system and user mappings
- **Complete**: Mark task as COMPLETED

### Task Management
- **Assign Task**: Associate task with user and schedule reminder
- **Search Task**: Keyword-based search across title, description, and assigned user
- **Filter Task**: Multi-criteria filtering by priority, date range, and user
- **View History**: Retrieve all tasks assigned to a user

### Reminder System
- Schedules reminder based on task due date
- Sends notification when task passes deadline and status is still ACTIVE
- Uses background threads for each reminder

## Happy Flow

```
User Registration → Task Creation → Task Assignment → Task Management → Task Tracking → Reminder Notification
```

1. Users are created with unique ID and name
2. User creates task with details and priority
3. Task assigned to another user, reminder scheduled
4. Users update, complete, or delete tasks as needed
5. Users search/filter tasks and view history
6. System sends reminders for overdue ACTIVE tasks

## Critical Sections (Thread Safety)

| Operation | Concurrency Issue | Solution |
|-----------|-------------------|----------|
| Task Creation & Assignment | Multiple simultaneous creations | ConcurrentHashMap |
| Task Updates | Race conditions during modifications | Synchronized updateTask() |
| Task Deletion | Partial deletions across maps | Synchronized deleteTask() |
| Task Completion | Status inconsistencies | Synchronized completeTask() |
| Singleton Creation | Multiple instance attempts | Synchronized getInstance() |

## Design Patterns

**Singleton Pattern**: TaskManager ensures single instance manages all tasks with thread-safe getInstance()

**Observer Pattern**: ReminderService monitors task deadlines (implicit implementation)

## Recommended Exceptions

| Exception | Use Case | Thrown By |
|-----------|----------|-----------|
| TaskNotFoundException | Task doesn't exist | updateTask(), deleteTask(), completeTask() |
| InvalidTaskAssignmentException | Invalid assignment operation | assignTask() |
| InvalidDateRangeException | Invalid filter date range | filterTask() |
| DuplicateTaskException | Duplicate task ID | createTask() |

## Key Questions & Answers

**Q: Can tasks be reassigned?**  
A: Yes, via updateTask() method

**Q: What reminder functionality?**  
A: Simple toggle-based system - reminder sent if task incomplete past deadline

**Q: Search scope?**  
A: All tasks regardless of status (current implementation)

**Q: How to handle concurrent updates?**  
A: Synchronized methods ensure thread-safe updates

**Q: Task history include deleted tasks?**  
A: No, deleted tasks are removed from history

## Utilities

- **ID Generation**: UUID.randomUUID() for unique task IDs
- **Date Operations**: LocalDateTime for timestamp management, ChronoUnit for delay calculations
- **Filtering**: Java Streams for efficient search and filter operations

## Technology Stack

- **Collections**: ConcurrentHashMap for thread-safe storage
- **Concurrency**: Synchronized methods, background threads for reminders
- **Date/Time**: java.time.LocalDateTime
- **Functional**: Java Streams for filtering