package Problems.MEDIUM.OnlineAuctionSystem.Model;

public class Account {
    private final String id;
    private User user;

    public Account(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
