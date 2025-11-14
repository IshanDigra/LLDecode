package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

public class User {
    private final int id;
    private final String name;
    private long reputation;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.reputation = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getReputation() {
        return reputation;
    }

    public void setReputation(long reputation) {
        this.reputation = reputation;
    }

    public synchronized void updateReputation(long val){
        reputation += val;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
