package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.LogMessage;

public interface OutputDestination {
    public void processLog(LogMessage message);
}
