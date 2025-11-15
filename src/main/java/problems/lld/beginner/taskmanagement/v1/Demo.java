package problems.lld.beginner.taskmanagement.v1;

import problems.lld.beginner.taskmanagement.v1.enums.TaskPriority;
import problems.lld.beginner.taskmanagement.v1.model.Task;
import problems.lld.beginner.taskmanagement.v1.model.TaskManager;
import problems.lld.beginner.taskmanagement.v1.model.User;

import java.time.LocalDateTime;

/**
 * Demo class for Task Management System.
 * Features:
 * - Create, update, and delete tasks
 * - Each task has: title, description, due date, priority, and status
 * - Assign tasks to other users and set reminders
 * - Search and filter tasks based on various criteria
 * - Mark tasks as completed and view task history
 */
public class Demo {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();
        
        // Create users
        User user1 = new User("1", "Ishan");
        User user2 = new User("2", "Pallav");

        // Create tasks
        Task task1 = taskManager.createTask(user1, "Movie Plan", "Planning about a movie", LocalDateTime.now().plusDays(1), TaskPriority.LOW);
        Task task2 = taskManager.createTask(user1, "Coding", "Coding schedule", LocalDateTime.now().plusSeconds(50), TaskPriority.HIGH);
        Task task3 = taskManager.createTask(user2, "Chill", "Planning about mandir visit", LocalDateTime.now().plusDays(2), TaskPriority.MEDIUM);

        // Assign tasks
        taskManager.assignTask(task1, user2);
        taskManager.assignTask(task2, user2);
        taskManager.assignTask(task3, user1);

        // Display all tasks
        System.out.println("\n=== All Tasks ===");
        System.out.println(taskManager.getTaskList());

        // Update task priority
        task1.setPriority(TaskPriority.MEDIUM);
        taskManager.updateTask(task1);

        // Search tasks
        System.out.println("\n=== Search Results for 'planning' ===");
        System.out.println(taskManager.searchTask("planning"));

        // Filter tasks
        System.out.println("\n=== Filter Tasks (MEDIUM priority, assigned to user1) ===");
        System.out.println(taskManager.filterTask(TaskPriority.MEDIUM, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(5), user1));

        // Delete a task
        taskManager.deleteTask(task1);
        System.out.println("\n=== Tasks after deletion ===");
        System.out.println(taskManager.getTaskList());
    }
}
