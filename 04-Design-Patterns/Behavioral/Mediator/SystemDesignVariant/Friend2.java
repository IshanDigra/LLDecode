package SystemDesign.Mediator;

public class Friend2 extends Friend{
    Friend2(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void send(String msg) {
        mediator.send(this,msg);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Ritesh Gets the message: "+msg);
    }
}
