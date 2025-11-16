package V2.Entities.Config;

import V2.Enums.SignalType;

public abstract class SignalConfig {
    protected int redDuration, greenDuration, yellowDuration;

    public SignalConfig(int redDuration, int greenDuration, int yellowDuration) {
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }


    public int getSignalDuration(SignalType type){
        if(type.equals(SignalType.RED)){
            return redDuration;
        }
        else if(type.equals(SignalType.GREEN)){
            return greenDuration;
        }
        else {
            return yellowDuration;
        }
    }
    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }


    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }
}
