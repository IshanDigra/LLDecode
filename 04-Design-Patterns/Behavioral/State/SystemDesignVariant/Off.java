package SystemDesign.state;

public class Off extends Remote{
    public void pressSwitch(TV context){
        System.out.println("Now off Going on");
        context.setState(new On());
    }
}
