package LLD_Problems.EASY.LoggingFramework;

import LLD_Problems.EASY.LoggingFramework.LogAppender.ConsoleAppender;

public class Logger {
    private static Logger instance;
    private LoggerConfig config;

    private Logger() {
//      setting the default config
        config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setConfig(LoggerConfig config) {
        this.config = config;
    }

    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void warn(String message){
        log(LogLevel.WARNING, message);
    }
    public void error(String message){
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message){
        log(LogLevel.FATAL, message);
    }

    public void log( LogLevel level, String message){
        if(level.ordinal()>= config.getLevel().ordinal()){
            LogMessage logMessage = new LogMessage(message, level);
            config.getAppender().append(logMessage);
        }
    }

}
