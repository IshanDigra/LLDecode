package TaskManagementSystem_V2.Service.ReminderConsumer;

import TaskManagementSystem_V2.Enum.TaskStatus;
import TaskManagementSystem_V2.Model.Reminder;
import TaskManagementSystem_V2.Model.Task;
import TaskManagementSystem_V2.Service.TaskManager;

import java.util.logging.Logger;

public class ConsoleReminderService implements ReminderService{
    private static final Logger logger = Logger.getLogger(ConsoleReminderService.class.getName());

    @Override
    public void sendReminder(Reminder reminder) {
        // logic for sending reminders.

         Task task = reminder.getTask();

        if(task.getStatus().equals(TaskStatus.ACTIVE)){
            logger.info("dear "+ task.getAssignedTo().getName()+" your task: "+ task.getTitle()+" is past its due date.");
        }
    }
}
