package LLD_Problems.MEDIUM.FaceBook.Model;

import LLD_Problems.MEDIUM.FaceBook.Constants.NotificationType;

import java.sql.Timestamp;

public class Notification {
    private final String id;
    private NotificationType type;
    private String content;
    private final Timestamp timestamp;
    private User user;

    public Notification(String id, NotificationType type, String content, User user) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
