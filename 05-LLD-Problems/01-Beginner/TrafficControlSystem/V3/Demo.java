package V2;
/*
* The traffic signal system should control the flow of traffic at an intersection with multiple roads.
The system should support different types of signals, such as red, yellow, and green.
The duration of each signal should be configurable and adjustable based on traffic conditions.
The system should handle the transition between signals smoothly, ensuring safe and efficient traffic flow.
The system should be able to detect and handle emergency situations, such as an ambulance or fire truck approaching the intersection.
The system should be scalable and extensible to support additional features and functionality.
* */


import V2.Entities.Road;
import V2.Entities.TrafficSignal;
import V2.Services.TrafficSignalControl;

public class Demo {
    public static void main(String[] args) {
        TrafficSignal t1 = new TrafficSignal();
        TrafficSignal t2 = new TrafficSignal();
        TrafficSignal t3 = new TrafficSignal();
        Road r1 = new Road("Ishan's Road", t1);
        Road r2 = new Road( "Gajri's Road", t2);
        Road r3 = new Road( "Pallav's Road", t3);


        TrafficSignalControl signal = TrafficSignalControl.getInstance();
        signal.addRoad(r1);
        signal.addRoad(r2);
        signal.addRoad(r3);
        signal.startSystem();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        signal.startEmergency(r3);


        try {
            Thread.sleep(5000);
            signal.startEmergency(r1);
            Thread.sleep(5000);
            signal.clearEmergency();
            Thread.sleep(5000);
            signal.clearEmergency();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
