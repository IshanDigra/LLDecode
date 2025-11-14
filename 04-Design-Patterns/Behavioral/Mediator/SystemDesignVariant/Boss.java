package SystemDesign.Mediator;

public class Boss extends Friend{
    Boss(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void send(String msg) {
        mediator.send(this,msg);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Ishan Gets the message: "+msg);
    }
}
