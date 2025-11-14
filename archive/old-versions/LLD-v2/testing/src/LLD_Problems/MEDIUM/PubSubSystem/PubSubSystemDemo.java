package LLD_Problems.MEDIUM.PubSubSystem;

public class PubSubSystemDemo {
    public static void main(String[] args) {
        Publisher pub1 = new Publisher("Penguins");
        Publisher pub2 = new Publisher("Ishan's Publications");

        Topic t1 = new Topic("science");
        Topic t2 = new Topic("Physics");

        Subscriber sub1 = new SubscriberImpl("chandler");
        Subscriber sub2 = new SubscriberImpl("Monica");
        Subscriber sub3 = new SubscriberImpl("Joey");

        pub1.addTopic(t1);
        pub2.addTopic(t2);

        // Subscribe to topics
        t1.addSubscriber(sub1);
        t1.addSubscriber(sub2);
        t2.addSubscriber(sub2);
        t2.addSubscriber(sub3);

        // Publish messages
        pub1.publish(t1, new Message("Message1 for Topic1", ""));
        pub1.publish(t1, new Message("Message2 for Topic1", ""));
        pub2.publish(t2, new Message("Message1 for Topic2", ""));


        // Unsubscribe from a topic
        t1.removeSubscriber(sub2);

        pub2.removeTopic(t2);

        // Publish more messages
        pub1.publish(t1, new Message("Message3 for Topic1", ""));
        pub2.publish(t2, new Message("Message2 for Topic2", ""));
    }
}
