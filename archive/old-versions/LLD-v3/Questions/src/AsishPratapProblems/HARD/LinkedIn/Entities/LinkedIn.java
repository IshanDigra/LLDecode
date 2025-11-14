package AsishPratapProblems.HARD.LinkedIn.Entities;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class LinkedIn {
    private static volatile LinkedIn instance;
    private SecurityService securityService;
    private Map<String, UserAccount> accounts;
    private Map<String, List<ConnectionRequest>> connectionRequests;

    // stores login session for various users.
    private Map<String, UserAccount> loginSessions;

    private LinkedIn() {
        accounts = new ConcurrentHashMap<>();
        securityService = new SecurityService(accounts);
        loginSessions = new ConcurrentHashMap<>();
        connectionRequests = new ConcurrentHashMap<>();
    }

    public static LinkedIn getInstance(){
        if(instance == null){
            synchronized (LinkedIn.class){
                if(instance == null){
                    instance = new LinkedIn();
                }
            }
        }
        return instance;
    }

    /*registration and authentication*/
    public void registerUser(String email, String password, String name){
        securityService.registerUser(email,password, name);
        connectionRequests.putIfAbsent(email, new CopyOnWriteArrayList<>());
    }

    public void logIn(String email, String password){
        if(loginSessions.containsKey(email)){
            System.out.println("User already LoggedIn");
            return;
        }
        UserAccount account = securityService.logIn(email, password);
        loginSessions.putIfAbsent(email, account);
    }

    public void logOut(String email){
        loginSessions.remove(email);
        System.out.println("Account Successfully Logged out");
    }

    // Update profile
    // for the case of simplicity adding name, education
    public void updateProfile(String email, String name, String education){
        if(loginSessions.containsKey(email)){
            UserAccount account = loginSessions.get(email);
            account.updateUserProfile(new Profile(name, education));
        }
        else{
            System.out.println("Please login first.");
        }
    }

    // connections
    // ideally speaking these actions should be done basis on the user id
    public void sendConnectionRequest(String sender, String reciever){
        // login check can be done here. if the sender is not logged in return
        List<ConnectionRequest> requests = connectionRequests.get(reciever);
        requests.add(new ConnectionRequest(accounts.get(sender)));
        connectionRequests.put(reciever, requests);
    }

    public void acceptConnectionRequest(String reciver, ConnectionRequest request){
        List<ConnectionRequest> requests = connectionRequests.get(reciver);
        requests.remove(request);

        // adding both the connections to each other.
        accounts.get(reciver).acceptConnection(request.getSender());
        request.getSender().acceptConnection(accounts.get(reciver));
    }

    public void viewConnections(String user){
        // ideally this method should return connections list.
        System.out.println("Viewing connections of "+ accounts.get(user).getName());
        accounts.get(user).getConnections().forEach(r-> System.out.println(r.getName()));
    }

    // messaging functionality
    public void sendMessage(String sender, String reciever, String content){
        Message message= new Message(sender, reciever, content);
        UserAccount source = accounts.get(sender);
        UserAccount dest = accounts.get(reciever);
        source.addMessage(dest, message);
        dest.addMessage(source, message);
    }
    public void viewInbox(String user){
        accounts.get(user).getInbox().forEach((u,v)-> System.out.println(u));
    }

    public void viewMessages(String user, String connection){
        accounts.get(user).getInbox().get(connection).forEach(m-> System.out.println(m));
    }

    // searching functionallity.

}
