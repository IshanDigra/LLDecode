package V2.Entities.OutputDestination;


import V2.Entities.LogMessage;

import java.util.logging.Logger;

public class Console implements OutputDestination{
    private static final Logger logger = Logger.getLogger(Console.class.getName());

    @Override
    public void processLog(LogMessage message) {
        logger.info("Message with content: "+message+" has been processed.");
    }
}
