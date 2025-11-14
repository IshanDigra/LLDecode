package SystemDesign.singleton;

public class MakeACaptain {
    private static MakeACaptain captain;

    private MakeACaptain(){}

    public static MakeACaptain getCaptain(){
        if(captain != null){
            System.out.println("you Already have a captain");
            return captain;
        }
        captain = new MakeACaptain();

        System.out.println("New Captain has been created");
        return captain;
    }
}
