package V2.Entities;


import V2.Enums.LogLevel;

import java.sql.Timestamp;

public class LogMessage {
    private final Timestamp time;
    private final String content;
    private final LogLevel level;

    public LogMessage(String content, LogLevel level) {
        this.content = content;
        this.level = level;
        time = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public LogLevel getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "time=" + time +
                ", content='" + content + '\'' +
                ", level=" + level +
                '}';
    }
}
