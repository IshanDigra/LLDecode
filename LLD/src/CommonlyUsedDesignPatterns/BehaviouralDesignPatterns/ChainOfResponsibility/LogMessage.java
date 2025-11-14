package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility;

import java.sql.Timestamp;

public class LogMessage {
    private LogLevel level;
    private String content;
    private final Timestamp time;

    public LogMessage(LogLevel level, String content) {
        this.level = level;
        this.content = content;
        time = new Timestamp(System.currentTimeMillis());
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "level=" + level +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
