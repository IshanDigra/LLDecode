package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogLevel;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogMessage;

public class Error extends Handler{
    public Error(LogLevel level) {
        super(level);
    }

    @Override
    public void handleRequest(LogMessage message) {
        System.out.println("Request moved to Error");
        super.handleRequest(message);
    }
}
