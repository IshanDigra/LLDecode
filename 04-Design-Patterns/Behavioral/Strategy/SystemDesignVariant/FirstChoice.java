package SystemDesign.Strategy;

public class FirstChoice implements IChoice{
    public void myChoice(String s1, String s2){
        System.out.print("You wanted to add numbers: ");

        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        System.out.println(n1+n2);
    }
}
