package SystemDesign.Facade;

public class FacadeRunner {
    public static void main(String[]args){
        RobotFacade rb1= new RobotFacade();
        rb1.createRobot("Bronze","Red");
        RobotFacade rb2= new RobotFacade();
        rb2.createRobot("Gold","Starlight");
    }
}
