package problems.lld.beginner.taskmanagement.v1.model;

import problems.lld.beginner.taskmanagement.v1.enums.TaskStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ReminderService handles basic reminder scheduling using threads.
 */
public class ReminderService {

    public void scheduleReminder(Task task, LocalDateTime startTime) {
        long delay = ChronoUnit.SECONDS.between(startTime, task.getDueDate());
        Thread th = new Thread(() -> {
            try {
                Thread.sleep(delay * 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            if (task.getStatus().equals(TaskStatus.ACTIVE)) {
                sendReminder(task);
            }
        });
        th.start();
    }

    private void sendReminder(Task task) {
        System.out.println("Dear " + task.getAssignedTo().getName() + ", your task: \"" + task.getTitle() + "\" is past its due date.");
    }
}
