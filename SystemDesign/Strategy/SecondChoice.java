package SystemDesign.Strategy;

public class SecondChoice implements IChoice{
    public void myChoice(String s1, String s2){
        System.out.print("You wanted to Subtract numbers: ");

        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        System.out.println(Math.abs(n1-n2));
    }
}
