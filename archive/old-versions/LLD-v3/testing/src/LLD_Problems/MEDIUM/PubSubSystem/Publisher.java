package LLD_Problems.MEDIUM.PubSubSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Publisher {
    private String name;
    private Set<Topic> topics;
    public Publisher(String name){
        this.name = name;
        topics = new CopyOnWriteArraySet<>();
    }

    public String getName(){
        return name;
    }

    public List<Topic> getTopics(){
        return new ArrayList<>(topics);
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void removeTopic(Topic topic){
        topics.remove(topic);
    }

    public void publish(Topic topic, Message msg){
        if(!topics.contains(topic)){
            System.out.println("Cannot publish on the mentioned topic :"+topic.getName());
        }
        else topic.publish(msg);
    }
}
