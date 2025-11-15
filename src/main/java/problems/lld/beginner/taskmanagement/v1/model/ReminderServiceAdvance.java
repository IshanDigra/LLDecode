package problems.lld.beginner.taskmanagement.v1.model;

import problems.lld.beginner.taskmanagement.v1.enums.TaskStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ReminderServiceAdvance uses ScheduledExecutorService for advanced reminder scheduling.
 */
public class ReminderServiceAdvance {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    public void scheduleReminder(Task task, LocalDateTime startTime) {
        long delay = ChronoUnit.SECONDS.between(startTime, task.getDueDate());
        scheduler.schedule(() -> sendReminder(task), delay, TimeUnit.SECONDS);
    }

    private void sendReminder(Task task) {
        if (task.getStatus().equals(TaskStatus.ACTIVE)) {
            System.out.println("Dear " + task.getAssignedTo().getName() + ", your task: \"" + task.getTitle() + "\" is past its due date.");
        }
    }

    public void closeService() {
        if (!scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }
}
