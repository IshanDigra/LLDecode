package LLD_Problems.MEDIUM.FaceBook.Model;

import java.sql.Timestamp;

public class ConnectionRequest {
    private final String id;
    private User sender;
    private final Timestamp timestamp;

    public ConnectionRequest(String id, User sender) {
        this.id = id;
        this.sender = sender;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
