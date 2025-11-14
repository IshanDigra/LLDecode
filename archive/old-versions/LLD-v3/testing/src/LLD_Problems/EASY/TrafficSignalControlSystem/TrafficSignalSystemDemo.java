package LLD_Problems.EASY.TrafficSignalControlSystem;

public class TrafficSignalSystemDemo {
    public static void main(String[] args) {
        TrafficLightManager manager = TrafficLightManager.getInstance();

        TrafficLight t1 = new TrafficLight("1",Signal.RED, 3000,9000,6000);
        TrafficLight t2 = new TrafficLight("2",Signal.RED, 3000,9000,6000);

        Road r1 = new Road("Dhangu Road","1",t1);
        Road r2 = new Road("Defence Road","2",t2);

        manager.addRoad(r1);
      //  manager.addRoad(r2);

        manager.startTrafficControl();



        manager.handleEmergency(r1.getId());


    }
}
