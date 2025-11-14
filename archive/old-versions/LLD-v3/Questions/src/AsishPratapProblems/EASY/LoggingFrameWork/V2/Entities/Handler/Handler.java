package AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.Handler;

import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.Configuration;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.LogMessage;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Entities.OutputDestination.OutputDestination;
import AsishPratapProblems.EASY.LoggingFrameWork.V2.Enums.LogLevel;

public abstract class Handler {
    protected static final Configuration configuration;
    protected Handler nextHandler;
    protected  LogLevel level;

    static {
        configuration = new Configuration();
        }

    public void setLevel(LogLevel level) {
        configuration.setLevel(level);
    }

    public void setDestination(OutputDestination destination) {
        configuration.setDestination(destination);
    }
    public Configuration getConfiguration() {
        return configuration;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void processLog(LogMessage message) throws Exception{
        if(message.getLevel().ordinal()-configuration.getLevel().ordinal()>=0){
            if(nextHandler == null) throw new RuntimeException("No valid hanler set");
           nextHandler.processLog(message);
        }
        else System.out.println("Ordinal of request is  less hence skipping the message: "+ message);
    }
}
