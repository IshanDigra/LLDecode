package SystemDesign.state;

public class On extends Remote{
    public void pressSwitch(TV context){
        System.out.println("Now on Going Off");
        context.setState(new Off());
    }
}
