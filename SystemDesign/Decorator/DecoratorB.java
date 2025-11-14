package SystemDesign.Decorator;

public class DecoratorB extends Decorator{
    public void doJob()
    {
        super.doJob();
        System.out.println("Decorator B doing Some Action after component job");

    }
}
