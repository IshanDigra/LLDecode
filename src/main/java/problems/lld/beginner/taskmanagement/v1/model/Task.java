package problems.lld.beginner.taskmanagement.v1.model;

import problems.lld.beginner.taskmanagement.v1.enums.TaskPriority;
import problems.lld.beginner.taskmanagement.v1.enums.TaskStatus;

import java.time.LocalDateTime;

/**
 * Task represents a task in the management system.
 * Task: id, title, description, due date, priority, status, assignedBy
 */
public class Task {
    private final String id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskPriority priority;
    private User assignedBy;
    private User assignedTo;
    private TaskStatus status;

    public Task(String id, String title, String description, LocalDateTime dueDate, TaskPriority priority, User assignedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignedBy = assignedBy;
        this.status = TaskStatus.ACTIVE;
        this.assignedTo = null;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(User assignedBy) {
        this.assignedBy = assignedBy;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", assignedBy=" + assignedBy.getName() +
                ", assignedTo=" + (assignedTo != null ? assignedTo.getName() : "null") +
                ", status=" + status +
                '}';
    }
}
