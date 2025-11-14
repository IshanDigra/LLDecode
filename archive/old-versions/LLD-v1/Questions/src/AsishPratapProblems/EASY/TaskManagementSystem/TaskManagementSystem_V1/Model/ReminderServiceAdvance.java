package AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Model;

import AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Enum.TaskStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderServiceAdvance {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    //first way
    public void sceduleReminder(Task task, LocalDateTime startTime){
        long delay = ChronoUnit.SECONDS.between(startTime, task.getDueDate());
        scheduler.schedule(()->sendReminder(task),delay, TimeUnit.SECONDS);
    }

    private void sendReminder(Task task){
        if(task.getStatus().equals(TaskStatus.ACTIVE))System.out.println("dear "+ task.getAssignedTo().getName()+" your task: "+ task.getTitle()+" is past its due date.");
        else System.out.println("");
    }
//     this needs to be done else the sevice weill keep on rinning. so threads method is much more simple.

    public void closeService(){
        if(!scheduler.isShutdown()){
            scheduler.shutdown();
        }
    }

}
