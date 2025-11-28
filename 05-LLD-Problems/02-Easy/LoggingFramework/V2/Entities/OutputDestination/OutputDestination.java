package V2.Entities.OutputDestination;


import V2.Entities.LogMessage;

public interface OutputDestination {
    void processLog(LogMessage message);
}
