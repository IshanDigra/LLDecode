package LLD_Problems.MEDIUM.Elevator;

public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(3, 1);

        controller.requestElevator(5, 7);
        controller.requestElevator(3, 7);
        controller.requestElevator(8, 2);
        controller.requestElevator(3, 9);
    }
}
