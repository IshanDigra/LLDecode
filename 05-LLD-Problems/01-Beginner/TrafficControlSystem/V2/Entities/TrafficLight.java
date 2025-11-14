package AsishPratapProblems.EASY.TrafficControlSystem.V2.Entities;

import AsishPratapProblems.EASY.TrafficControlSystem.V2.Enums.SignalType;

public class TrafficLight {
    private SignalType currSignal;
    private int redDuration;
    private int greenDuration;
    private int yellowDuration;

    public TrafficLight(int redDuration, int greenDuration, int yellowDuration) {
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        currSignal = SignalType.RED;
    }

    public SignalType getCurrSignal() {
        return currSignal;
    }

    public void setCurrSignal(SignalType currSignal) {
        this.currSignal = currSignal;
    }

    public int getCurrentSignalDuration(){
        if(currSignal.equals(SignalType.RED)) return redDuration;
        else if(currSignal.equals(SignalType.GREEN)) return greenDuration;
        else return yellowDuration;
    }
}
