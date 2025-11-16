package V2.Entities;


import V2.Enums.SignalType;
import V2.Util.IdUtil;

public class TrafficSignal {
    private SignalType currSignal;
    private final String id;

    public TrafficSignal() {
        currSignal = SignalType.RED;
        id = IdUtil.generateTSId();
    }

    public SignalType getCurrSignal() {
        return currSignal;
    }

    public void setCurrSignal(SignalType currSignal) {
        this.currSignal = currSignal;
    }

    public String getId() {
        return id;
    }
}
