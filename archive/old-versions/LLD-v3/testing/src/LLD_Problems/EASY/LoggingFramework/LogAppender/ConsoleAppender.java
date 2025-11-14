package LLD_Problems.EASY.LoggingFramework.LogAppender;

import LLD_Problems.EASY.LoggingFramework.LogMessage;

public class ConsoleAppender implements LogAppender {

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logMessage);
    }
}
