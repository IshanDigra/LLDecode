# Task Management System V2

## Problem Statement

The task management system should allow users to create, update, and delete tasks. Each task should have a title, description, due date, priority, and status (e.g., pending, in progress, completed). Users should be able to assign tasks to other users and set reminders for tasks. The system should support searching and filtering tasks based on various criteria (e.g., priority, due date, assigned user). Users should be able to mark tasks as completed and view their task history. The system should handle concurrent access to tasks and ensure data consistency. The system should be extensible to accommodate future enhancements and new features.

## Happy Flow

1. Users are created with unique ID and name
2. Task creator creates a task with title, description, due date, and priority
3. Task is assigned to another user, triggering automatic reminder scheduling
4. Assigned user can update task properties including priority, description, and status
5. Users can search tasks by keyword across title, description, or assigned user
6. Users can filter tasks by priority, date range, and assigned user
7. Users can mark tasks as completed or delete them
8. System sends automatic reminders when task passes due date and remains ACTIVE
9. Users can view their task history showing all assigned tasks

## Entities

| Entity | Properties | Methods |
|--------|-----------|---------|
| Task | id, title, description, dueDate, priority, status, assignedBy, assignedTo | setPriority(), setStatus(), setTitle(), setDescription(), setAssignedTo() |
| User | id, name | setName() |
| Reminder | task, scheduledtime | getTask(), getScheduledtime() |
| TaskManager | userTasksMapping, taskList, reminderScheduler | createTask(), updateTask(), deleteTask(), completeTask(), assignTask(), unassignTask(), searchTask(), filterTask(), viewHistory() |
| ReminderScheduler | scheduler, consoleService | scheduleReminder(), sendReminder(), closeService() |

## Enums

| Enum | Values | Purpose |
|------|--------|---------|
| TaskPriority | LOW, MEDIUM, HIGH | Define task priority levels |
| TaskStatus | ACTIVE, COMPLETED, DELETED | Track task lifecycle state |

## Services & Core Functionalities

| Service | Responsibilities | Key Methods |
|---------|-----------------|-------------|
| TaskManager | Central task management, CRUD operations, user-task mapping | createTask(), updateTask(), deleteTask(), completeTask(), assignTask(), unassignTask(), searchTask(), filterTask(), viewHistory() |
| ReminderScheduler | Automated reminder scheduling using background threads | scheduleReminder(), sendReminder(), closeService() |
| ReminderService | Interface for reminder delivery mechanisms | sendReminder() |
| ConsoleReminderService | Console-based reminder delivery implementation | sendReminder() |

### Core Operations

**CRUD Operations:**
- Create: Generate new task with auto-generated ID using AtomicLong counter
- Update: Modify task properties with automatic task reassignment handling
- Delete: Remove task from system and user mappings with status update
- Complete: Mark task status as COMPLETED

**Task Assignment:**
- Assign task to user with bidirectional mapping
- Unassign task when reassigning to different user
- Automatic reminder scheduling upon assignment

**Search & Filter:**
- Search: Keyword-based search across title, description, and assigned user name
- Filter: Multi-criteria filtering by priority, date range, and assigned user

**Reminder System:**
- Scheduled using ScheduledExecutorService with thread pool of 5
- Calculates delay from current time to due date
- Sends reminder only if task status remains ACTIVE after due date
- Extensible design using ReminderService interface

## Critical Sections

| Operation | Concurrency Risk | Thread-Safety Mechanism |
|-----------|------------------|-------------------------|
| Task Creation | Race condition on ID generation | AtomicLong counter |
| Task Assignment | Multiple simultaneous assignments | ConcurrentHashMap for storage |
| Task Update | Concurrent modifications | Synchronized updateTask() method |
| Task Deletion | Partial deletion across maps | Synchronized deleteTask() method |
| Task Completion | Status inconsistencies | Synchronized completeTask() method |
| Singleton Creation | Multiple instance creation | Double-checked locking with volatile |

## Exceptions

| Exception | Use Case | Thrown By |
|-----------|----------|-----------|
| RuntimeException | Task not found during update | updateTask() |
| InterruptedException | Scheduler shutdown timeout | closeService() |

Note: Custom exceptions should be implemented for better error handling:
- TaskNotFoundException
- InvalidTaskAssignmentException
- InvalidDateRangeException
- DuplicateTaskException

## Utilities

| Utility | Purpose | Implementation |
|---------|---------|----------------|
| IdGenerator | Generate unique sequential task IDs | AtomicLong counter with ID- prefix |
| LocalDateTime | Date and time operations | Java 8 time API |
| ChronoUnit | Calculate delay between dates | SECONDS.between() for reminder scheduling |
| Streams | Search and filter operations | Java 8 Streams for filtering tasks |

## Questions to Ask

**Q: Can tasks be reassigned to different users after initial assignment?**  
A: Yes, tasks can be reassigned. The updateTask() method handles reassignment by unassigning from the original user and assigning to the new user.

**Q: What reminder functionality should the system provide?**  
A: For simplicity, the system uses a toggle-based reminder that automatically sends notification if task remains incomplete past the due date. This is handled by a separate ReminderScheduler service that tracks task deadlines.

**Q: Does task history include deleted tasks?**  
A: No, deleted tasks are removed from the user-task mapping. Only ACTIVE and COMPLETED tasks appear in history.

**Q: How are concurrent updates handled?**  
A: Synchronized methods ensure thread-safe updates. ConcurrentHashMap provides thread-safe storage for tasks and user mappings.

**Q: Can the reminder service be extended?**  
A: Yes, the ReminderService interface allows implementing different reminder delivery mechanisms (e.g., email, SMS, push notifications) beyond the current console implementation.

**Q: What is the scope of search functionality?**  
A: Search works across all tasks regardless of status, matching keywords in title, description, or assigned user name (case-insensitive).

**Q: How is the task ID generated?**  
A: Task IDs are generated using AtomicLong counter with format "ID-{number}" ensuring unique, sequential, thread-safe ID generation.