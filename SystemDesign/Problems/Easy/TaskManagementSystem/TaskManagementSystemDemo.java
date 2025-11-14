package SystemDesign.Problems.Easy.TaskManagementSystem;

import java.util.Date;
import java.util.List;

public class TaskManagementSystemDemo extends Thread{
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User user1 = new User("John Doe", "1", "john@example.com");
        User user2 = new User("Jane Smith", "2", "jane@example.com");

        Task task1 = new Task("1", "Task 1", "Description 1", new Date(),  user1, Priority.HIGH, Status.PENDING);
        Task task2 = new Task("2", "Task 2", "Description 2", new Date(),  user2, Priority.LOW, Status.PENDING);
        Task task3 = new Task("3", "Task 3", "Description 3", new Date(),  user1, Priority.NORMAL, Status.PENDING);

        // Add tasks to the task manager
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        // Update a task
        task2.setDescription("Updated description");
        taskManager.updateTask(task2);

        // Search tasks
        List<Task> searchResults = taskManager.searchTask("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter tasks
        List<Task> filteredTasks = taskManager.filterTasks(Status.PENDING, new Date(0), new Date(), Priority.HIGH);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as completed
        taskManager.markTaskAsCompleted("1");

        // Get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskManager.deleteTask("3");

    }
}
