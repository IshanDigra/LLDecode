package V2.Entities.Handler;


import V2.Entities.LogMessage;
import V2.Enums.LogLevel;

public class WarningHandler extends Handler{
    public WarningHandler() {
        level = LogLevel.WARNING;
    }

    @Override
    public void processLog(LogMessage message){
        if(message.getLevel().equals(this.level)){
            configuration.getDestination().processLog(message);
        }
        else{
            try {
                super.processLog(message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
