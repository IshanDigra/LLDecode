package AsishPratapProblems.HARD.LinkedIn.Entities;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserAccount {
    private String name;
    private String email;
    private String password;
    private Profile userProfile;
    private List<UserAccount> connections;
    private Map<UserAccount, List<Message>> inbox;

    public UserAccount(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        connections = new CopyOnWriteArrayList<>();
        inbox = new ConcurrentHashMap<>();
    }

    public void addMessage(UserAccount connection, Message message){
        List<Message> messages = inbox.getOrDefault(connection, new CopyOnWriteArrayList<>());
        messages.add(message);
        inbox.put(connection,messages);
    }

    public void acceptConnection(UserAccount account){
        connections.add(account);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void updateUserProfile(Profile profile){

    }

    public List<UserAccount> getConnections() {
        return connections;
    }

    public Map<UserAccount, List<Message>> getInbox() {
        return inbox;
    }
}
