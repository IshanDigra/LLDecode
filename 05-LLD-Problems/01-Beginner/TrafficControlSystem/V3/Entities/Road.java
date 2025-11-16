package V2.Entities;

import V2.Util.IdUtil;

public class Road {
    private final String id; 
    private final String name;
    private final TrafficSignal trafficLight;

    public Road(String name, TrafficSignal trafficLight) {
        this.name = name;
        id = IdUtil.generateRoadId();
        // not a very good design. Say we make changes in the Traffic signal then this 
        // a tight coupling. 
        //trafficLight = new TrafficSignal();
        this.trafficLight = trafficLight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TrafficSignal getTrafficLight() {
        return trafficLight;
    }
}
