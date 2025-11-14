package AsishPratapProblems.EASY.LoggingFrameWork.V1;
/*
* Core Functionalities: defaultConfig, setConfig, logAction
* */


import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.LoggingFrameWork;
import AsishPratapProblems.EASY.LoggingFrameWork.V1.Entities.OutputDestination.ConsoleLog;
import AsishPratapProblems.EASY.LoggingFrameWork.V1.Enums.LogLevel;

public class Demo {
    public static void main(String[] args) {
        LoggingFrameWork logger = LoggingFrameWork.getInstance();

        logger.debug("normal debugging message");
        logger.info("normal info message");

        logger.setConfig(LogLevel.ERROR, new ConsoleLog());
        logger.debug("normal debugging message");
        logger.info("normal info message");
        logger.fatal("Fatal Message");
    }
}
