package SystemDesign.singleton;

public class MakeACaptain2 {
    private static MakeACaptain2 captain;

    private MakeACaptain2(){}

    public static MakeACaptain2 getCaptain(){
        if(captain != null){
            System.out.println("you Already have a captain");
            return captain;
        }
        captain = new MakeACaptain2();

        System.out.println("New Captain has been created");
        return captain;
    }
}
