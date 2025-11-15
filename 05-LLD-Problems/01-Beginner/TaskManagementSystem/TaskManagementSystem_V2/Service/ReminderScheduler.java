package TaskManagementSystem_V2.Service;

import TaskManagementSystem_V2.Enum.TaskStatus;
import TaskManagementSystem_V2.Model.Reminder;
import TaskManagementSystem_V2.Model.Task;
import TaskManagementSystem_V2.Service.ReminderConsumer.ConsoleReminderService;
import TaskManagementSystem_V2.Service.ReminderConsumer.ReminderService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;


/*
*
*
* */

public class ReminderScheduler {
    ScheduledExecutorService scheduler;
    ReminderService consoleService;

    public ReminderScheduler() {
         scheduler = Executors.newScheduledThreadPool(5);
         consoleService = new ConsoleReminderService();
    }

    //first way
    public void sceduleReminder(Reminder reminder)  {
        Task task = reminder.getTask();
        LocalDateTime startTime = reminder.getScheduledtime();

        long delay = ChronoUnit.SECONDS.between(startTime, task.getDueDate());
        scheduler.schedule(()->sendReminder(reminder),delay, SECONDS);

    }

    // we could add extra logic for various other kind of modes for sending out remidners.
    private void sendReminder(Reminder reminder){
        consoleService.sendReminder(reminder);
    }
//     this needs to be done else the sevice weill keep on rinning. so threads method is much more simple.

    public void closeService() throws InterruptedException {
        if(!scheduler.isShutdown()){
            scheduler.awaitTermination(120,TimeUnit.SECONDS);
        }
    }

}
