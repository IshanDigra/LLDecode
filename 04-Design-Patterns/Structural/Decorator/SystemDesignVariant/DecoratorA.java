package SystemDesign.Decorator;

public class DecoratorA extends Decorator{
    public void doJob(){
        System.out.println("Decorator A doing Some Action before component job");
        super.doJob();
    }
}
