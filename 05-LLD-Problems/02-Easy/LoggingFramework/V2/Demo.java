package V2;


import V2.Entities.LogMessage;
import V2.Entities.LoggingFrameWork;
import V2.Enums.LogLevel;

public class Demo {
    public static void main(String[] args) {
        LoggingFrameWork instance = LoggingFrameWork.getInstance();
        instance.setLevel(LogLevel.ERROR);
        instance.processLog(new LogMessage("This is a debug message", LogLevel.DEBUG));
        instance.processLog(new LogMessage("This is a Error message", LogLevel.ERROR));
        instance.setLevel(LogLevel.WARNING);
        instance.processLog(new LogMessage("This is a Error2 message", LogLevel.ERROR));
    }
}
