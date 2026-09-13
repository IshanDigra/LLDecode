package SystemDesign.Mediator;

public class Friend1 extends Friend{
    Friend1(Mediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void send(String msg) {
        mediator.send(this,msg);
    }

    @Override
    public void notify(String msg) {
        System.out.println("Rajdeep Gets the message: "+msg);
    }
}
