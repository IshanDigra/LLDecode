package SystemDesign.state;

public class StateRunner {
    public static void main(String[] args){
        TV context = new TV(new Off());
        context.pressButton();
        context.pressButton();
    }
}
