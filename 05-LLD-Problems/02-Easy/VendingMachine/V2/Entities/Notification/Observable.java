package V2.Entities.Notification;


import V2.Entities.Product;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer) ;
    void notifyObservers(Product product);
}
