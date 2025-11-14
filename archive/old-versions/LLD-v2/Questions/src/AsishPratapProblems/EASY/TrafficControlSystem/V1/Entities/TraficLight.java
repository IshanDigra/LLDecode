package AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities;

import AsishPratapProblems.EASY.TrafficControlSystem.V1.Enum.Signal;

/*road, currentSignal, greenSignal Duration....*/
public class TraficLight {
    private Signal currentSignal;
    private long greenSignalDuration;
    private long redSignalDuration;
    private long yellowSignalDuration;

    public TraficLight(long greenSignalDuration, long redSignalDuration, long yellowSignalDuration) {
        this.greenSignalDuration = greenSignalDuration;
        this.redSignalDuration = redSignalDuration;
        this.yellowSignalDuration = yellowSignalDuration;
        currentSignal = Signal.RED;
    }

    public void setCurrentSignal(Signal signal) {

        this.currentSignal = signal;
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public long getGreenSignalDuration() {
        return greenSignalDuration;
    }

    public void setGreenSignalDuration(long greenSignalDuration) {
        this.greenSignalDuration = greenSignalDuration;
    }

    public long getRedSignalDuration() {
        return redSignalDuration;
    }

    public void setRedSignalDuration(long redSignalDuration) {
        this.redSignalDuration = redSignalDuration;
    }

    public long getYellowSignalDuration() {
        return yellowSignalDuration;
    }

    public void setYellowSignalDuration(long yellowSignalDuration) {
        this.yellowSignalDuration = yellowSignalDuration;
    }
}
