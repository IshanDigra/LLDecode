package LLD_Problems.MEDIUM.PubSubSystem;

import java.util.UUID;

public class SubscriberImpl implements Subscriber{
    private String id;
    private String name;

    public SubscriberImpl(String name){
        this.name = name;
        id = UUID.randomUUID().toString();
    }
    public void onMessage(Message msg){
        System.out.println("Subscriber "+ name + " received message :"+ msg.getTitle());
    }
}
