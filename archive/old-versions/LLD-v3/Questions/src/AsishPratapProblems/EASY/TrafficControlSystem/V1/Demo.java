package AsishPratapProblems.EASY.TrafficControlSystem.V1;
/*
* The traffic signal system should control the flow of traffic at an intersection with multiple roads.
The system should support different types of signals, such as red, yellow, and green.
The duration of each signal should be configurable and adjustable based on traffic conditions.
The system should handle the transition between signals smoothly, ensuring safe and efficient traffic flow.
The system should be able to detect and handle emergency situations, such as an ambulance or fire truck approaching the intersection.
The system should be scalable and extensible to support additional features and functionality.
* */

import AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities.Road;
import AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities.TrafficSignal;
import AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities.TraficLight;

public class Demo {
    public static void main(String[] args) {
        TraficLight t1 = new TraficLight(10,10,10);
        TraficLight t2 = new TraficLight(10,10,10);
        TraficLight t3 = new TraficLight(10,10,10);
        Road r1 = new Road("1", "Ishan's Road", t1);
        Road r2 = new Road("2", "Gajri's Road", t2);
        Road r3 = new Road("3", "Pallav's Road", t3);


        TrafficSignal signal = TrafficSignal.getInstace();
        signal.addRoad(r1);
        signal.addRoad(r2);
        signal.addRoad(r3);
        signal.startTrafficCycle();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        signal.activateEmergencySituation(r3);


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        signal.deactivateEmergencySituation(r1);
    }
}
