package LLD_Problems.MEDIUM.FaceBook.Model;

import LLD_Problems.MEDIUM.LinkedIn.Model.Connection;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private Profile profile;
    private List<User> fiends;
    private List<Post> posts;
    private List<ConnectionRequest> pendingRequests;
    public User(String id, String name, String email, String phone, String password, Profile profile, List<User> fiends, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.profile = profile;
        this.fiends = fiends;
        this.posts = posts;
        pendingRequests = new ArrayList<>();
    }

    //


    public List<ConnectionRequest> getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(List<ConnectionRequest> pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public List<User> getFiends() {
        return fiends;
    }

    public void setFiends(List<User> fiends) {
        this.fiends = fiends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
