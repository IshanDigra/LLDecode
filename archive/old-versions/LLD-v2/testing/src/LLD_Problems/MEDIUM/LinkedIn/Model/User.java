package LLD_Problems.MEDIUM.LinkedIn.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;



    private final String name;
    private final String email;
    private final String password;
    private Profile profile;
    private final List<User> connections;
    private final List<Connection> connectionRequests;
    private final List<Message> inbox;
    private final List<Message> sentMessages;

    public User(String id, String name, String email, String password, Profile profile, List<Connection> connectionRequests, List<Message> inbox, List<Message> sentMessages) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.connections = new ArrayList<>();
        this.connectionRequests = connectionRequests;
        this.inbox = inbox;
        this.sentMessages = sentMessages;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Connection> getConnectionRequests() {
        return connectionRequests;
    }

    public List<User> getConnections() {
        return connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", connections=" + connections +
                ", connectionRequests=" + connectionRequests +
                ", inbox=" + inbox +
                ", sentMessages=" + sentMessages +
                '}';
    }
}
