package LLD_Problems.MEDIUM.PubSubSystem;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class Topic {
    private String id;
    private String name;
    private Set<Subscriber> subscribers;

    public Topic(String name){
        this.name = name;
        id = UUID.randomUUID().toString();
        subscribers = new CopyOnWriteArraySet<>();
    }

//  getters
    public String getName(){
        return name;
    }
    public List<Subscriber> getSubscribers(){
        return subscribers.stream().collect(Collectors.toList());
    }

    public void addSubscriber(Subscriber subs){
        subscribers.add(subs);
    }

    public void removeSubscriber(Subscriber subs){
        subscribers.remove(subs);
    }

    public void publish(Message msg){
        for(Subscriber subs : subscribers){
            subs.onMessage(msg);
        }
    }
}
