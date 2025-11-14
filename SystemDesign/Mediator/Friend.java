package SystemDesign.Mediator;

public abstract class Friend {
    Mediator mediator;
    String name;

    Friend(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void send(String msg);
    public abstract void notify(String msg);
}
