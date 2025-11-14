package SystemDesign.Decorator;

public class DecoratorRunner {
    public static void main(String[] args){
        Component cmp = new ConcreteComponent();

        Decorator A = new DecoratorA();
        Decorator B = new DecoratorB();

        A.setComponent(cmp);
        B.setComponent(cmp);

        A.doJob();
        B.doJob();
    }
}
