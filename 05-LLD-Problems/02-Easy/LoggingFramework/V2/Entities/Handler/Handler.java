package V2.Entities.Handler;


import V2.Entities.Configuration;
import V2.Entities.LogMessage;
import V2.Entities.OutputDestination.OutputDestination;
import V2.Enums.LogLevel;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Handler {
    // Since this configuration is going to be global & same for all hence making it static.
    protected static final Configuration configuration;
    protected Handler nextHandler;
    protected LogLevel level;

    protected static final Logger logger;

    static {
        configuration = new Configuration();
        logger = Logger.getLogger(Handler.class.getName());
        }

    public void setLevel(LogLevel level) {
        logger.info("The log level has been set to : "+ level);
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
            if(nextHandler == null) throw new RuntimeException("No valid handler set");
           nextHandler.processLog(message);
        }
        else{
            logger.warning("Ordinal of request is  less hence skipping the message: "+ message);
        }
    }
}
