package SystemDesign.Mediator;

public class MediatorRunner {
    public static void main(String[] args){
        ConcreteMediator mediator = new ConcreteMediator();
        Friend1 F1= new Friend1(mediator,"rajdeep");
        Friend2 F2= new Friend2(mediator,"ritesh");
        Boss B = new Boss(mediator, "Ishan");

        mediator.setFriend1(F1);
        mediator.setFriend2(F2);
        mediator.setBoss(B);

        F1.send("rajdeep here");
        F2.send("ritesh here");
        B.send("Ishan here get to work you fools");
    }
}
