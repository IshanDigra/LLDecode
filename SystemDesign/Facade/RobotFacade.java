package SystemDesign.Facade;

public class RobotFacade {
    public RobotColor rc ;
    public RobotBody rb ;

    public RobotMetal rm ;

    RobotFacade(){
        rc = new RobotColor();
        rb = new RobotBody();
        rm = new RobotMetal();
    }

    public void createRobot(String metal, String color){
        rb.createBody();
        rc.setColor(color);
        rm.setMetal(metal);

        System.out.println("Robot Created");
    }
}
