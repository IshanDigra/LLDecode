package LLD_Problems.EASY.LoggingFramework;

import LLD_Problems.EASY.LoggingFramework.LogAppender.ConsoleAppender;

public class LoggerConfig {
    private LogLevel level;
    private ConsoleAppender appender;

    public LoggerConfig(LogLevel level, ConsoleAppender appender) {
        this.level = level;
        this.appender = appender;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public ConsoleAppender getAppender() {
        return appender;
    }

    public void setAppender(ConsoleAppender appender) {
        this.appender = appender;
    }
}
