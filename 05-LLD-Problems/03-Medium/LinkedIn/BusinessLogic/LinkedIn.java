package LLD_Problems.MEDIUM.LinkedIn.BusinessLogic;

import LLD_Problems.MEDIUM.LinkedIn.Constants.NotificationType;
import LLD_Problems.MEDIUM.LinkedIn.Model.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedIn {
    private Map<String, User> users;
    private Map<String, JobPosting> jobPostings;
    private Map<String, List<Notification>> notifications;
    private static LinkedIn instance;

    private LinkedIn(){
        users = new ConcurrentHashMap<>();
        jobPostings = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
    }
    public static LinkedIn getInstance(){
        if(instance == null){
            instance = new LinkedIn();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public User loginUser(String email, String password){
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    // profile action

    public void updateProfile(User user){
        System.out.println("Updating profile" + user.toString());
        users.put(user.getId(), user);
    }


    // connection action

    public void sendConnectionRequest(User sender, User receiver){
         Connection connectionReq = new Connection(sender,new Timestamp(System.currentTimeMillis()));
         receiver.getConnectionRequests().add(connectionReq);
         // notification logic
        Notification notification = new Notification(generateNotificationId(), receiver,
        NotificationType.CONNECTION_REQUEST, "New connection request from " + sender.getName(),
                new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(), notification);
        System.out.println("New connection request from " + sender.getName() + " to " + receiver.getName());
    }

    public void acceptConnectionRequest(User user, User connectionUser){
        for(Connection connection : user.getConnectionRequests()){
            if(connection.getUser().equals(connectionUser)){
                user.getConnections().add(connectionUser);
                connectionUser.getConnections().add(user);
                // Notification logic for connection User recieving connection accepted request;
                Notification notification = new Notification(generateNotificationId(), connectionUser,
                        NotificationType.CONNECTION_REQUEST, user.getId() + " Accepted connection request",
                        new Timestamp(System.currentTimeMillis()));
                addNotification(connectionUser.getId(), notification);
                System.out.println("Connection accepted from " + user.getName() + " to " + connectionUser.getName());
                break;
            }
        }
    }

    // messaging action
    public void sendMessage(User sender, User receiver, String message){
        Message message1 = new Message(generateMessageId(), sender, receiver, message,
                new Timestamp(System.currentTimeMillis()));
        sender.getSentMessages().add(message1);
        receiver.getInbox().add(message1);
        // Notifcation logic
        Notification notification = new Notification(generateNotificationId(), receiver,
                NotificationType.MESSAGE, "New message from " + sender.getName(),
                new Timestamp(System.currentTimeMillis()));
        addNotification(receiver.getId(), notification);
        System.out.println("New message from " + sender.getName() + " to " + receiver.getName());
    }

    // job posting action
    public void postJob(JobPosting jobPosting){
        jobPostings.put(jobPosting.getId(), jobPosting);
        for(User user : users.values()){
            // notification logic
            Notification notification = new Notification(generateNotificationId(), user,
                    NotificationType.JOB_POSTING, "New job posting: " + jobPosting.getTitle(),
                    new Timestamp(System.currentTimeMillis()));
            addNotification(user.getId(), notification);
        }
    }

    // notification action
    private void addNotification(String userId, Notification notification) {
        notifications.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }
    // search aciton
    public List<JobPosting> searchJobPostings(String keyword) {
        List<JobPosting> results = new ArrayList<>();
        for (JobPosting jobPosting : jobPostings.values()) {
            if (jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
                results.add(jobPosting);
            }
        }
        return results;
    }
    public List<User> searchUsers(String keyword) {
        List<User> results = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getName().contains(keyword)) {
                results.add(user);
            }
        }
        return results;
    }


    // Id generation Action
    private String generateNotificationId() {
        return "NOTIF"+UUID.randomUUID().toString();
    }

    private String generateMessageId() {
        return "MSG"+UUID.randomUUID().toString();
    }
}
