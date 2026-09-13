package SystemDesign.Strategy;

public class Context {
    IChoice myC;

    public void setChoice(IChoice choice){
        myC = choice;
    }

    public void  getChoice(String s1, String s2){
        myC.myChoice(s1,s2);
    }
}
