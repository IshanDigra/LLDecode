package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ObserverDesignPattern;

public class MessageAlertObserver implements Observer{
    private String userName;

    public MessageAlertObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Observable o) {
        System.out.println("new Message sent to "+ userName + "\n" + "Message Content: Iphone stock has been restocked to : "+ o.getData());
    }


}
