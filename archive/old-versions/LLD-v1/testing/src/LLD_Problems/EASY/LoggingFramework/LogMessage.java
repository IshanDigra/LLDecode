package LLD_Problems.EASY.LoggingFramework;

import java.util.Date;

public class LogMessage {
    private final String content;
    private final Date timeStamp = new Date(System.currentTimeMillis());
    private LogLevel level;

    public LogMessage(String content, LogLevel level) {
        this.content = content;
        this.level = level;
    }

    public String getContent() {
        return content;
    }


    public Date getTimeStamp() {
        return timeStamp;
    }

    /*public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }*/

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "content='" + content + '\'' +
                ", timeStamp=" + timeStamp +
                ", level=" + level +
                '}';
    }
}
