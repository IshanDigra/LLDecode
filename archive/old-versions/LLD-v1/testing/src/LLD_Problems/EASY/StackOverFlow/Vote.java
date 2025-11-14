package LLD_Problems.EASY.StackOverFlow;

public class Vote {
    private int value;
    private User user;

    public Vote(int value, User user) {
        this.value = value;
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }
}
