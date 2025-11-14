package AsishPratapProblems.EASY.LoggingFrameWork.V2;


import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LogMessage;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LoggingFrameWork;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Enums.LogLevel;

public class Demo {
    public static void main(String[] args) {
        LoggingFrameWork instance = LoggingFrameWork.getInstance();
        instance.setLevel(LogLevel.ERROR);
        instance.processLog(new LogMessage("This is a debug message", LogLevel.DEBUG));
    }
}
