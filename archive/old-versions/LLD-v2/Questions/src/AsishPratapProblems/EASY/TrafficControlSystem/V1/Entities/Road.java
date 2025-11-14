package AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities;
/*Road: id, name, TrafficLight*/
public class Road {
    private final String id ;
    private String name;
    private TraficLight light;

    public Road(String id, String name, TraficLight light) {
        this.id = id;
        this.name = name;
        this.light = light;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TraficLight getLight() {
        return light;
    }

    public void setLight(TraficLight light) {
        this.light = light;
    }
}
