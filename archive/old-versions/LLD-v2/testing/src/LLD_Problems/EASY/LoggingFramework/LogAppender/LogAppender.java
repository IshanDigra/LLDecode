package LLD_Problems.EASY.LoggingFramework.LogAppender;

import LLD_Problems.EASY.LoggingFramework.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
