package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogLevel;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogMessage;

public class Debug extends Handler{
    public Debug(LogLevel level) {
        super(level);
    }

    @Override
    public void handleRequest(LogMessage message) {
        System.out.println("Request moved to debug");
        super.handleRequest(message);
    }
}
