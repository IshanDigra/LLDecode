package AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities;

import AsishPratapProblems.EASY.LoggingFrameWork.V1.Enums.LogLevel;

import java.sql.Timestamp;

/*content, time, logLvl*/
public class LogMessage {
    private final String content;
    private LogLevel lvl;
    private Timestamp time;

    public LogMessage(String content, LogLevel lvl) {
        this.content = content;
        this.lvl = lvl;
        time = new Timestamp(System.currentTimeMillis());
    }

    public String getContent() {
        return content;
    }

    public LogLevel getLvl() {
        return lvl;
    }

    public void setLvl(LogLevel lvl) {
        this.lvl = lvl;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "content='" + content + '\'' +
                ", lvl=" + lvl +
                ", time=" + time +
                '}';
    }
}
