package V2.Service.Notification;


import V2.Enum.*;


public interface Observable {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyObserver(Ingredient ingredient);
}
