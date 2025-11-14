package AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.OutputDestination;

import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LogMessage;

public interface OutputDestination {
    void processLog(LogMessage message);
}
