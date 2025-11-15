package TaskManagementSystem_V2;

import TaskManagementSystem_V2.Enum.TaskPriority;
import TaskManagementSystem_V2.Model.Task;
import TaskManagementSystem_V2.Service.TaskManager;
import TaskManagementSystem_V2.Model.User;


import java.time.LocalDateTime;

/*
* The task management system should allow users to create, update, and delete tasks.
Each task should have a title, description, due date, priority, and status (e.g., pending, in progress, completed).
Users should be able to assign tasks to other users and set reminders for tasks.
The system should support searching and filtering tasks based on various criteria (e.g., priority, due date, assigned user).
Users should be able to mark tasks as completed and view their task history.
* */
public class Demo {
    public static void main(String[] args) {

        TaskManager tm = TaskManager.getInstance();
        User user1 = new User("1", "ishan");
        User user2 = new User("2", "pallav");

        // create update delete task check
        Task t1 = tm.createTask(user1, "Movie Plan", "Planning about a movie", LocalDateTime.now().plusSeconds(60), TaskPriority.LOW) ;
        Task t2 = tm.createTask(user1, "Coding", "coding schedule", LocalDateTime.now().plusSeconds(50), TaskPriority.HIGH) ;
        Task t3 = tm.createTask(user2, "Chill", "Planning about mandir visit", LocalDateTime.now().plusSeconds(2), TaskPriority.MEDIUM) ;
        // assign task

        tm.assginTask(t1,user2);
        tm.assginTask(t2,user2);
        tm.assginTask(t3,user1);

        System.out.println(tm.getTaskList());
        t1.setPriority(TaskPriority.MEDIUM);
        tm.updateTask(t1);
        // search

        System.out.println(tm.searchTask("planning"));
        // filter

        System.out.println(tm.filterTask(TaskPriority.MEDIUM,LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1),user1));
        // task history

        tm.deleteTask(t1);
      // tm.completeTask(t2);

        System.out.println(tm.getTaskList());
    }
}
