package AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer) ;
    void notifyObservers(Product product);
}
