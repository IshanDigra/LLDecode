package LLD_Problems.MEDIUM.FaceBook;

import LLD_Problems.MEDIUM.FaceBook.Model.*;
import LLD_Problems.MEDIUM.FaceBook.Service.FaceBook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        FaceBook socialNetworkingService = FaceBook.getInstance();

        // User registration
        User user1 = new User("1", "John Doe", "john@example.com", "password", "password", new Profile("","","" ), new ArrayList<>(), new ArrayList<>());
        User user2 = new User("2", "Jane Smith", "jane@example.com", "password", "profile2.jpg", new Profile("","","" ), new ArrayList<>(), new ArrayList<>());
        socialNetworkingService.registerUser(user1);
        socialNetworkingService.registerUser(user2);

        // User login
        User loggedInUser = socialNetworkingService.login("john@example.com", "password");
        if (loggedInUser != null) {
            System.out.println("User logged in: " + loggedInUser.getName());
        } else {
            System.out.println("Invalid email or password.");
        }

        // Send friend request
        socialNetworkingService.sendFriendRequest(user1, user2);
        socialNetworkingService.sendFriendRequest(user2, user1);

        // Accept friend request
        socialNetworkingService.acceptFriendRequest(user1, user2);
        socialNetworkingService.acceptFriendRequest(user2, user1);
        // Create posts
        Post post1 = new Post("p1","post1", "Hi there ishu", new ArrayList<>(),new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),user1);
        Post post2 = new Post("p2","post2", "testing 2 ", new ArrayList<>(),new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),user2);
        socialNetworkingService.createPost(post1);
        socialNetworkingService.createPost(post2);

        // Like a post
        socialNetworkingService.likePost(post1, user2);

        // Comment on a post
        Comment comment = new Comment("1","Good going there", user2);
        socialNetworkingService.commentPost(post1, comment);

        // Get newsfeed
        List<Post> newsfeed = socialNetworkingService.getNewsfeed(user1);
        System.out.println("Newsfeed:");
        for (Post post : newsfeed) {
            System.out.println("Post: " + post.getDescription());
            System.out.println("Likes: " + post.getLikes().size());
            System.out.println("Comments: " + post.getComments().size());
            System.out.println();
        }

        // Get notifications
//        List<Notification> notifications = socialNetworkingService.getNotifications(user1.getId());
//        System.out.println("Notifications:");
//        for (Notification notification : notifications) {
//            System.out.println("Type: " + notification.getType());
//            System.out.println("Content: " + notification.getContent());
//            System.out.println();
//        }
    }
}
