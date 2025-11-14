package AsishPratapProblems.EASY.TrafficControlSystem.V2.Entities;

public class Road {
    private final String name;
    private final TrafficLight light;

    public Road(String name, int defSetting) {
        this.name = name;
        // default setting.
        light = new TrafficLight(defSetting,defSetting, defSetting);
    }

    public String getName() {
        return name;
    }

    public TrafficLight getLight() {
        return light;
    }

    // provide methods for chanfing the default signal duration settings.
}
