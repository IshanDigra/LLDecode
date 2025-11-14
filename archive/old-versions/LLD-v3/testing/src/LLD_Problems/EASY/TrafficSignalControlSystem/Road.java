package LLD_Problems.EASY.TrafficSignalControlSystem;

public class Road {
    private final String roadName;
    private final String id;
    private TrafficLight trafficLight;

    public Road(String roadName, String id, TrafficLight trafficLight) {
        this.roadName = roadName;
        this.id = id;
        this.trafficLight = trafficLight;
    }

    public String getRoadName() {
        return roadName;
    }

    public String getId() {
        return id;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
}
