package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogLevel;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogMessage;

public class Warning extends Handler{
    public Warning(LogLevel level) {
        super(level);
    }

    @Override
    public void handleRequest(LogMessage message) {
        System.out.println("Request moved to warning");
        super.handleRequest(message);
    }
}
