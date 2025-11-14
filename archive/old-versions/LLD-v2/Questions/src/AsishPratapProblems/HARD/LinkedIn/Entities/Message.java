package AsishPratapProblems.HARD.LinkedIn.Entities;

import java.sql.Timestamp;

public class Message {
    private final String sender;
    private final String reciever;
    private final String content;
    private final Timestamp time;

    public Message(String sender, String reciever, String content) {
        this.sender = sender;
        this.reciever = reciever;
        this.content = content;
        time = new Timestamp(System.currentTimeMillis());
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", reciever='" + reciever + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
