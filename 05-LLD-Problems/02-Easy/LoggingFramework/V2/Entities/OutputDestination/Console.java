package AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LogMessage;

public class Console implements OutputDestination{
    @Override
    public void processLog(LogMessage message) {
        System.out.println("Message with content: "+message+" has been processed.");
    }
}
