package SystemDesign.Problems.Easy.TaskManagementSystem;

import java.util.Date;

public class Task {

    private String id;
    private String title;
    private String description;
    private Date dueDate;

    private User assignedUser;

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getId() {
        return id;
    }

    public Task(String id, String title, String description, Date dueDate, User assignedUser, Priority priority, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedUser = assignedUser;
        this.priority = priority;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Priority priority;

    private Status status;



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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
