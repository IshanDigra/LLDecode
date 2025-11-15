package TaskManagementSystem_V2.Model;

import java.time.LocalDateTime;

/*
 *
 * In future more details can be added in this object.
 *
 * */
public class Reminder {
    private final Task task;
    private final LocalDateTime scheduledtime;

    public Reminder(Task task, LocalDateTime scheduledtime) {
        this.task = task;
        this.scheduledtime = scheduledtime;
    }

    public Task getTask() {
        return task;
    }

    public LocalDateTime getScheduledtime() {
        return scheduledtime;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "task=" + task +
                ", scheduledtime=" + scheduledtime +
                '}';
    }
}
