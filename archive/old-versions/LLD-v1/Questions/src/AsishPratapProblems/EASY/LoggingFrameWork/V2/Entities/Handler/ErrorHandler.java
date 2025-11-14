package AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.Handler;

import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LogMessage;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Enums.LogLevel;

public class ErrorHandler extends Handler{
    public ErrorHandler() {
        level = LogLevel.ERROR;
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
