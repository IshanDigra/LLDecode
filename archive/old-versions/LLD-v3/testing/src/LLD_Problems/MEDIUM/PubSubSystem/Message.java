package LLD_Problems.MEDIUM.PubSubSystem;

import java.sql.Timestamp;

public class Message {
    private String title;
    private String body;
    private final Timestamp timestamp;

    public Message(String title, String body){
        this.title = title;
        this.body = body;

        timestamp = new Timestamp(System.currentTimeMillis());
    }
//  getters
    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }
    public Timestamp getTimestamp(){
        return this.timestamp;
    }

//  Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }

}
