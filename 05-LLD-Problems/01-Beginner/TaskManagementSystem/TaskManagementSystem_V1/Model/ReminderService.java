package AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Model;

import AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Enum.TaskStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ReminderService {

    //first way
    public void sceduleReminder(Task task, LocalDateTime startTime){
        long delay = ChronoUnit.SECONDS.between(startTime, task.getDueDate());
        Thread th = new Thread(()->{
            try {
                Thread.sleep(delay*100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // for the case of active only we send reminder. rest deleted and everyother case should be
            // handled separately. For the case we are updating the due date. if its less than current
            //
            if(task.getStatus().equals(TaskStatus.ACTIVE))sendReminder(task);
        });
        th.start();
    }

    private void sendReminder(Task task){
        System.out.println("dear "+ task.getAssignedTo().getName()+" your task: "+ task.getTitle()+" is past its due date.");
    }
}
