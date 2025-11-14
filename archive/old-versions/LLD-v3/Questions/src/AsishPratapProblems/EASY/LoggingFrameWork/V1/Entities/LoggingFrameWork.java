package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination.ConsoleLog;
import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination.OutputDestination;
import AsishPratapProblems.EASY.LoggingFrameWork.V1.Enums.LogLevel;

public class LoggingFrameWork {
    private static LoggingFrameWork instance;
    private Config config;

    private LoggingFrameWork(){
        config = new Config(LogLevel.DEBUG, new ConsoleLog());
    }

    public static synchronized LoggingFrameWork getInstance(){
        if(instance==null){
            instance = new LoggingFrameWork();
        }
        return instance;
    }

    public void setConfig(LogLevel lvl, OutputDestination dest){
        config.setConfiguration(lvl, dest);
    }

    private void log(LogLevel lvl, String message){
        if(lvl.ordinal() >= config.getLvl().ordinal()){
            LogMessage msg = new LogMessage(message, lvl);
            config.getDest().processLog(msg);
        }
    }

    public void debug(String message){
        log(LogLevel.DEBUG,message);
    }
    //DEBUG, INFO, WARNING, ERROR, FATAL
    public  void info(String message){
        log(LogLevel.INFO,message);
    }
    public void warning(String message){
        log(LogLevel.WARNING,message);
    }
    public void error(String message){
        log(LogLevel.ERROR, message);
    }
    public void fatal(String message){
        log(LogLevel.FATAL, message);
    }
}
