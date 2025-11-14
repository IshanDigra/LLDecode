package LLD_Problems.EASY.TrafficSignalControlSystem;

public class TrafficLight {
    private final String id;
    private Signal currentSignal;
    private int greenDuration;
    private int redDuration;
    private int yellowDuration;

    public TrafficLight(String id, Signal currentSignal, int greenDuration, int redDuration, int yellowDuration) {
        this.id = id;
        this.currentSignal = currentSignal;
        this.greenDuration = greenDuration;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
    }

    public String getId() {
        return id;
    }


    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public void setCurrentSignal(Signal currentSignal) {
        this.currentSignal = currentSignal;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }
}
