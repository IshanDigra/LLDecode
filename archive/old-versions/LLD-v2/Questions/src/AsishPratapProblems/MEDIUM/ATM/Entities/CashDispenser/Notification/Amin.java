package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.Notification;

public class Amin implements Observer{
    private String name;

    public Amin(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
