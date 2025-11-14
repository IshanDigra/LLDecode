package AsishPratapProblems.HARD.LinkedIn.Entities;

import java.sql.Timestamp;

public class ConnectionRequest {
    private final UserAccount sender;
    private final Timestamp time;

    public ConnectionRequest(UserAccount sender) {
        this.sender = sender;
        time = new Timestamp(System.currentTimeMillis());
    }

    public UserAccount getSender() {
        return sender;
    }

    public Timestamp getTime() {
        return time;
    }
}
