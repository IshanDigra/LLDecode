package SystemDesign.Strategy;

public class StrategyRunner {
    public static void main(String[] args){
        IChoice c1 = new FirstChoice();
        IChoice c2 = new SecondChoice();

        Context cont = new Context();

        cont.setChoice(c1);
        cont.getChoice("2","3");

        cont.setChoice(c2);
        cont.getChoice("2","3");
    }
}
