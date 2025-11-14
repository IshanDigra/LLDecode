package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.Notification;

public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}
