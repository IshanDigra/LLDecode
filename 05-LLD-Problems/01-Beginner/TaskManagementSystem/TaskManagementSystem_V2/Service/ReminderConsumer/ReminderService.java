package TaskManagementSystem_V2.Service.ReminderConsumer;

import TaskManagementSystem_V2.Model.Reminder;

/*
*
* Generic reminder service -- defines the various modes of sending reminders.
*
* */
public interface ReminderService {
    void sendReminder(Reminder reminder);
}
