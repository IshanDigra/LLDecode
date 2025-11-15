package problems.lld.beginner.taskmanagement.v1.model;

import problems.lld.beginner.taskmanagement.v1.enums.TaskPriority;
import problems.lld.beginner.taskmanagement.v1.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * TaskManager handles all task operations including create, update, delete, assign, search, and filter.
 * Uses Singleton pattern and thread-safe collections for concurrent access.
 */
public class TaskManager {
    private static TaskManager instance;
    private final Map<String, List<Task>> userTasksMapping;
    private final Map<String, Task> taskList;
    private final ReminderService reminderService;

    private TaskManager() {
        this.userTasksMapping = new ConcurrentHashMap<>();
        this.taskList = new ConcurrentHashMap<>();
        this.reminderService = new ReminderService();
    }

    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public Task createTask(User creator, String title, String description, LocalDateTime dueDate, TaskPriority priority) {
        System.out.println("New task has been created by " + creator.getName());
        return new Task(idGenerator(), title, description, dueDate, priority, creator);
    }

    public synchronized void updateTask(Task updatedTask) {
        Task originalTask = taskList.get(updatedTask.getId());
        if (originalTask != null) {
            originalTask.setDescription(updatedTask.getDescription());
            originalTask.setPriority(updatedTask.getPriority());
            originalTask.setStatus(updatedTask.getStatus());
            originalTask.setTitle(updatedTask.getTitle());
            if (updatedTask.getAssignedTo() != null && !originalTask.getAssignedTo().equals(updatedTask.getAssignedTo())) {
                unassignTask(originalTask, originalTask.getAssignedTo());
                assignTask(originalTask, updatedTask.getAssignedTo());
            }
        } else {
            throw new RuntimeException("No active task present with the given id");
        }
    }

    public synchronized void deleteTask(Task task) {
        taskList.remove(task.getId());
        User user = task.getAssignedTo();
        if (user != null) {
            List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), null);
            if (tasks != null) {
                tasks.remove(task);
            }
        }
    }

    public synchronized void completeTask(Task task) {
        task.setStatus(TaskStatus.COMPLETED);
    }

    public void assignTask(Task task, User user) {
        task.setAssignedTo(user);
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), new LinkedList<>());
        tasks.add(task);
        System.out.println("New task has been assigned to " + user.getName() + " by " + task.getAssignedBy().getName());
        userTasksMapping.put(user.getId(), tasks);
        taskList.put(task.getId(), task);
        reminderService.scheduleReminder(task, LocalDateTime.now());
    }

    public void unassignTask(Task task, User user) {
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), new LinkedList<>());
        tasks.remove(task);
    }

    public List<Task> searchTask(String keyword) {
        return taskList.values().stream()
                .filter(task -> task.getAssignedTo().getName().equalsIgnoreCase(keyword) ||
                        task.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                        task.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Task> filterTask(TaskPriority priority, LocalDateTime startDate, LocalDateTime endDate, User user) {
        return taskList.values().stream()
                .filter(task -> task.getAssignedTo().getName().equalsIgnoreCase(user.getName()) &&
                        task.getPriority().equals(priority) &&
                        task.getDueDate().isAfter(startDate) &&
                        task.getDueDate().isBefore(endDate))
                .collect(Collectors.toList());
    }

    public List<Task> viewHistory(User user) {
        return userTasksMapping.getOrDefault(user.getId(), new ArrayList<>());
    }

    private String idGenerator() {
        return UUID.randomUUID().toString();
    }

    public List<Task> getTaskList() {
        return new ArrayList<>(taskList.values());
    }
}
