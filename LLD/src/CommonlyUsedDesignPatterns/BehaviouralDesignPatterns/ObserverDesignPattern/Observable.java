package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ObserverDesignPattern;

public interface Observable {
    public void add(Observer o);
    public void remove(Observer o);
    public void notifySubscribers();
    public void setData(int x);

    public int getData();
}
