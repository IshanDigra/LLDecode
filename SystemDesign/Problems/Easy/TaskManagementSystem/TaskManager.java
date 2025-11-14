package SystemDesign.Problems.Easy.TaskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance;

    private final Map<String, List<Task>> users;
    private final Map<String,Task> tasks;

    private TaskManager(){
       users = new ConcurrentHashMap<>();
       tasks = new ConcurrentHashMap<>();
    }

    //  Singleton Design Pattern
    public static synchronized TaskManager getInstance(){
        if(instance == null){
            instance = new TaskManager();
        }
        return instance;
    }

    public void createTask(Task task){
        // add task in tasks
        tasks.put(task.getId(), task);
        // add task corresponding to a user.
        assignTask(task.getAssignedUser(), task);
        System.out.println("Task "+ task.getTitle() + " with Priority "+ task.getPriority()+ " and Due date "+ task.getDueDate()+" Created");
    }

    public void updateTask(Task updatedTask){
        Task existingTask = tasks.get(updatedTask.getId());
        if (existingTask != null) {
            synchronized (existingTask) {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setPriority(updatedTask.getPriority());
                existingTask.setStatus(updatedTask.getStatus());
                User previousUser = existingTask.getAssignedUser();
                User newUser = updatedTask.getAssignedUser();
                if (!previousUser.equals(newUser)) {
                    unassignTask(previousUser, existingTask);
                    assignTask(newUser, existingTask);

                }
                System.out.println("Task Updated");
            }
        }
    }

    public void deleteTask(String taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            unassignTask(task.getAssignedUser(), task);
            System.out.println("Task Deleted");
        }
    }

    public void assignTask(User user, Task task){
        users.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>()).add(task);
    }

    public void unassignTask(User user, Task task){
        List<Task> tasks = users.get(user.getId());
        if(tasks!=null){
            tasks.remove(task);
        }
    }


    public List<Task> searchTask(String keyword){
        List<Task> matchingTasks = new ArrayList<>();

        for(Task task : tasks.values()){
            if(task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
        }


    public List<Task> filterTasks(Status status, Date startDate, Date endDate, Priority priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus() == status &&
                    task.getDueDate().compareTo(startDate) >= 0 &&
                    task.getDueDate().compareTo(endDate) <= 0 &&
                    task.getPriority() == priority) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void markTaskAsCompleted(String taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            synchronized (task) {
                task.setStatus(Status.COMPLETE);
            }
        }
    }

    public List<Task> getTaskHistory(User user) {
        return new ArrayList<>(users.getOrDefault(user.getId(), new ArrayList<>()));
    }
}
