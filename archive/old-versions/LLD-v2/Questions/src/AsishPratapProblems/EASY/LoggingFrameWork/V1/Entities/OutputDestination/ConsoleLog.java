package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.LogMessage;

public class ConsoleLog implements OutputDestination{
    @Override
    public void processLog(LogMessage message) {
        System.out.println(message);
    }
}
