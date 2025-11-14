package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ObserverDesignPattern;

public class EmailAlertObserver implements Observer{
    private String userName;

    public EmailAlertObserver(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(Observable o) {
        System.out.println("new Email sent to "+ userName + "\n" + "Email Content: Iphone stock has been restocked to : "+ o.getData());
    }


}
