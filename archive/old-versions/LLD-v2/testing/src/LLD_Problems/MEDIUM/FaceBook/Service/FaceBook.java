package LLD_Problems.MEDIUM.FaceBook.Service;


import LLD_Problems.MEDIUM.FaceBook.Model.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FaceBook {
    private static FaceBook instance;
    private Map<String, User> users;
    private Map<String, Post> posts;
    private Map<String, List<Notification>> notifications;

    private FaceBook(){
        users = new ConcurrentHashMap<>();
        posts = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
    }

    public static FaceBook getInstance(){
        if(instance == null){
            instance = new FaceBook();
        }
        return instance;
    }

    // User action
    public void registerUser(User user){

        System.out.println("New User registered");

        users.put(user.getId(), user);
    }

    public User login(String email, String password){
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void updateProfile(User user){
        users.put(user.getId(), user);
    }

    // friend request
    public void sendFriendRequest(User sender, User receiver){
        ConnectionRequest request = new ConnectionRequest(generateConnectionId(),sender);
        receiver.getPendingRequests().add(request);
        System.out.println(sender.getName()+ " Sent friend request "+ receiver.getName());
        // notification logic
    }

    public void acceptFriendRequest(User sender, User receiver){
        for(ConnectionRequest request : receiver.getPendingRequests()){
            if(request.getSender().equals(sender)){
                receiver.getFiends().add(sender);
                // notification logic
                System.out.println(receiver.getName()+ " Accepted friend request "+ sender.getName());
                break;
            }
        }
    }

    public void rejectFriendRequest(User sender, User receiver){
        for(ConnectionRequest request : receiver.getPendingRequests()){
            if(request.getSender().equals(sender)){
                receiver.getPendingRequests().remove(request);
                System.out.println(receiver.getName()+ " Rejected friend request "+ sender.getName());
                // notification logic
                break;
            }
        }
    }


    // Post related
    public Post createPost(Post post){
        posts.put(post.getId(), post);
        User user = post.getUser();
        user.getPosts().add(post);
        System.out.println(user.getName() +"Post created");
        return post;
    }

    public void likePost(Post post, User user){
        post.getLikes().add(user.getId());
        System.out.println(user.getName() +"Liked post "+ post.getId());
        // notification logic
    }

    public void commentPost(Post post, Comment comment){
        post.getComments().add(comment);
        System.out.println(comment.getAuthor().getName() +"Comment post "+ post.getId());
        // notif logic

    }
    // search related

    public List<Post> getNewsfeed(User user) {
        List<Post> newsfeed = new ArrayList<>();
        newsfeed.addAll(user.getPosts());
        for(User friend : user.getFiends()){
            newsfeed.addAll(friend.getPosts());
        }
        newsfeed.sort((p1,p2)->{p2.getTimestamp().compareTo(p1.getTimestamp());return 0;});
        return newsfeed;
    }

    // notif related

    private void addNotification(String userId, Notification notification) {
        notifications.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>()).add(notification);
    }

    public List<Notification> getNotifications(String userId) {
        return notifications.getOrDefault(userId, new ArrayList<>());
    }

    // user id generation.
    private String generateConnectionId(){
        return "Connection"+UUID.randomUUID().toString();
    }
}
