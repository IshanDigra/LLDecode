package SystemDesign.ChainOfResponsibility;

public class Message {
    public String text;
    public MessagePriority priority;

    Message(String msg, MessagePriority priority){
        this.priority = priority;
        text = msg;
    }
}
