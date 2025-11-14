package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination.OutputDestination;
import AsishPratapProblems.EASY.LoggingFrameWork.V1.Enums.LogLevel;

/*logLevel, outputDestination*/
public class Config {
    private LogLevel lvl;
    private OutputDestination dest;

    // default configuration

    public Config(LogLevel lvl, OutputDestination dest) {
        this.lvl = lvl;
        this.dest = dest;
    }

    public void setConfiguration(LogLevel lvl, OutputDestination dest) {
        this.lvl = lvl;
        this.dest = dest;
    }

    public LogLevel getLvl() {
        return lvl;
    }

    public void setLvl(LogLevel lvl) {
        this.lvl = lvl;
    }

    public OutputDestination getDest() {
        return dest;
    }

    public void setDest(OutputDestination dest) {
        this.dest = dest;
    }
}
