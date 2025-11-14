package AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Model;

import AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Enum.TaskPriority;
import AsishPratapProblems.EASY.TaskManagementSystem.TaskManagementSystem_V1.Enum.TaskStatus;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*
* TaskManagement: Map<user, activeTaskList> activeTasks, Map<user, activeTaskList> completedTasks, List<Tasks> tasks
createTask, updateTask{delete, complete}, assginTask, searchTask, filterTask, viewHistory,
* */
public class TaskManager {
    private static TaskManager instance;
    private Map<String, List<Task>> userTasksMapping;
    private Map<String, Task> taskList;
    private final ReminderService rm;

    private TaskManager(){
        userTasksMapping = new ConcurrentHashMap<>();
        taskList = new ConcurrentHashMap<>();

        rm = new ReminderService();
    }
    public static synchronized TaskManager getInstance(){
        if(instance == null){
            instance = new TaskManager();
        }
        return instance;

    }

    public Task createTask(User creator, String title, String description, LocalDateTime dueDate, TaskPriority priority){
        System.out.println("new task has been created by "+ creator.getName());
        Task task = new Task(idGenerator(), title, description, dueDate, priority, creator);
        return task;
    }
    public synchronized void updateTask(Task updatedTask){
        Task originalTask = taskList.get(updatedTask.getId());
        if(originalTask!=null){
            originalTask.setDescription(updatedTask.getDescription());
            originalTask.setPriority(updatedTask.getPriority());
            originalTask.setStatus(updatedTask.getStatus());
            originalTask.setTitle(updatedTask.getTitle());
           // originalTask.setDueDate(updatedTask.getDueDate());
            if(!originalTask.getAssignedTo().equals(updatedTask.getAssignedTo())){
                unassignTask(originalTask, originalTask.getAssignedTo());
                assginTask(originalTask, updatedTask.getAssignedTo());
            }
        }
        else{
            throw new RuntimeException("No active task present with the given id");
        }

    }
    public synchronized void deleteTask(Task task){
        taskList.remove(task.getId());
        User user = task.getAssignedTo();
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(),null);
        if(tasks!=null)tasks.remove(task);
        userTasksMapping.put(user.getId(), tasks);
    }

    public synchronized void completeTask(Task task){
        task.setStatus(TaskStatus.COMPLETED);
    }

    public void assginTask(Task task, User user){
        task.setAssignedTo(user);
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), new LinkedList<>());
        tasks.add(task);
        System.out.println("new task has been assigned to "+ user.getName()+ " by "+task.getAssignedBy().getName());
        userTasksMapping.put(user.getId(), tasks);
        taskList.put(task.getId(),task);
        rm.sceduleReminder(task,LocalDateTime.now());
    }
    public void unassignTask(Task task, User user){
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), new LinkedList<>());
        tasks.remove(task);
        userTasksMapping.put(user.getId(), tasks);
    }
    public List<Task> searchTask(String keyword){
        return taskList.values().stream().filter(r->r.getAssignedTo().getName().equalsIgnoreCase(keyword) ||
                r.getDescription().toLowerCase().contains(keyword.toLowerCase())|| r.getTitle().toLowerCase().contains(keyword.toLowerCase())
                ).collect(Collectors.toList());
    }
    public List<Task> filterTask( TaskPriority priority, LocalDateTime startDate, LocalDateTime endDate, User user){
        return taskList.values().stream().filter(r->r.getAssignedTo().getName().equalsIgnoreCase(user.getName()) &&
                r.getPriority().equals(priority) && (r.getDueDate().isAfter(startDate)&& r.getDueDate().isBefore(endDate))
                ).collect(Collectors.toList());
    }

    public List<Task> viewHistory(User user){
        return userTasksMapping.getOrDefault(user.getId(), null);
    }
    public String idGenerator(){
        return UUID.randomUUID().toString();
    }

    public List<Task> getTaskList() {
        return taskList.values().stream().collect(Collectors.toList());
    }
}
