package V2.Entities;

import V2.Util.Utility;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private final String id;
    private final String name;
    private final AtomicLong reputation;

    public User( String name) {
        this.id = Utility.UserId();
        this.name = name;
        reputation = new AtomicLong(0);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public AtomicLong getReputation() {
        return reputation;
    }

    public synchronized void updateReputation(Long val){
        reputation.addAndGet(val);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
