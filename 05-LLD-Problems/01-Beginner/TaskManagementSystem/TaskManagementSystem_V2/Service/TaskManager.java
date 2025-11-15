package TaskManagementSystem_V2.Service;

import TaskManagementSystem_V2.Enum.TaskPriority;
import TaskManagementSystem_V2.Enum.TaskStatus;
import TaskManagementSystem_V2.Model.Reminder;
import TaskManagementSystem_V2.Model.Task;
import TaskManagementSystem_V2.Model.User;
import TaskManagementSystem_V2.Util.IdGenerator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
* TaskManagement: Map<user, activeTaskList> activeTasks, Map<user, activeTaskList> completedTasks, List<Tasks> tasks
createTask, updateTask{delete, complete}, assginTask, searchTask, filterTask, viewHistory,
* */
public class TaskManager {
    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());
    private static volatile TaskManager instance;
    private final Map<String, List<Task>> userTasksMapping;
    private final Map<String, Task> taskList;
    private final ReminderScheduler reminderScheduler;

    private TaskManager(){
        userTasksMapping = new ConcurrentHashMap<>();
        taskList = new ConcurrentHashMap<>();

        reminderScheduler = new ReminderScheduler();
    }
    public static TaskManager getInstance(){
        if(instance == null){
            synchronized (TaskManager.class){
                if(instance == null){
                    instance = new TaskManager();
                }
            }
        }
        return instance;

    }

    public Task createTask(User creator, String title, String description, LocalDateTime dueDate, TaskPriority priority){
        logger.info("new task has been created by "+ creator.getName());
        Task task = new Task(IdGenerator.generateNextId(), title, description, dueDate, priority, creator);
        return task;
    }
    public synchronized void updateTask(Task updatedTask)  {
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
        task.setStatus(TaskStatus.DELETED);
        userTasksMapping.put(user.getId(), tasks);
    }

    public synchronized void completeTask(Task task){
        task.setStatus(TaskStatus.COMPLETED);
    }

    public void assginTask(Task task, User user)  {
        task.setAssignedTo(user);
        List<Task> tasks = userTasksMapping.getOrDefault(user.getId(), new LinkedList<>());
        tasks.add(task);
        logger.info("new task has been assigned to "+ user.getName()+ " by "+task.getAssignedBy().getName());
        userTasksMapping.put(user.getId(), tasks);
        taskList.put(task.getId(),task);
        reminderScheduler.sceduleReminder(new Reminder(task,LocalDateTime.now()));
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


    public List<Task> getTaskList() {
        return taskList.values().stream().collect(Collectors.toList());
    }
}
