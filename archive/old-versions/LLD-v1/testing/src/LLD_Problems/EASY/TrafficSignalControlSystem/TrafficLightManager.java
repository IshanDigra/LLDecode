package LLD_Problems.EASY.TrafficSignalControlSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficLightManager {
    private Map<String, Road> roads;
    private static TrafficLightManager instance;

    private TrafficLightManager(){
        roads = new ConcurrentHashMap<>();
    }

    public static synchronized TrafficLightManager getInstance(){
        if(instance == null){
            instance = new TrafficLightManager();
        }
        return instance;
    }

    public void removeRoad(String roadId){
        roads.remove(roadId);
        System.out.println("Removed road " + roadId);
    }

    public void addRoad(Road road){
        roads.put(road.getId(), road);
        System.out.println("Added road " + road.getRoadName());
    }

    public void startTrafficControl() {
        for (Road road : roads.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
                while (true) {
                    try {
                        Thread.sleep(trafficLight.getRedDuration());
                        System.out.println("changing "+ road.getRoadName()+"'s traffic light from red to green");
                        trafficLight.setCurrentSignal(Signal.GREEN);
                        Thread.sleep(trafficLight.getGreenDuration());
                        System.out.println("changing "+ road.getRoadName()+"'s traffic light from green to yellow");;
                        trafficLight.setCurrentSignal(Signal.YELLOW);
                        Thread.sleep(trafficLight.getYellowDuration());
                        System.out.println("changing "+ road.getRoadName()+"'s traffic light from yellow to red");
                        trafficLight.setCurrentSignal(Signal.RED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }
    }

    public void handleEmergency(String roadId) {
        Road road = roads.get(roadId);
        if (road != null) {
            System.out.println("Emergency road " + roadId);
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.setCurrentSignal(Signal.GREEN);
            Thread th = new Thread(()->{
                try{
                    System.out.println("Handling Emergency Situation");
                    Thread.sleep(9000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Perform emergency handling logic
            // ...
        }
    }

}