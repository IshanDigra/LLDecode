package SystemDesign.Observer;

public interface ISubject {
    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyObservers();
}
