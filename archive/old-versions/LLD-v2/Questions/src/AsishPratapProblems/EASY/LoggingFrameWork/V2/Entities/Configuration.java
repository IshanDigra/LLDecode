package AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities;

import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.Handler.DebugHandler;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.Handler.Handler;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.OutputDestination.Console;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.OutputDestination.OutputDestination;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Enums.LogLevel;

public class Configuration {
    private LogLevel level;
    private OutputDestination destination;

    public Configuration() {
        level = LogLevel.DEBUG;
        destination = new Console();
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public OutputDestination getDestination() {
        return destination;
    }

    public void setDestination(OutputDestination destination) {
        this.destination = destination;
    }
}
