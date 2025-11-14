package SystemDesign.singleton;


public class SingletonRunner {
    public static void main(String[] args) {
        MakeACaptain c1 = MakeACaptain.getCaptain();
        MakeACaptain c2 = MakeACaptain.getCaptain();

        if(c1==c2){
            System.out.println("Both instances of captain are same :)");
        }
    }
}
