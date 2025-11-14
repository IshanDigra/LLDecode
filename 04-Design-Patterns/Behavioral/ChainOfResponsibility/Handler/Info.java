package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogLevel;

public class Info extends Handler{
    public Info(LogLevel level) {
        super(level);
    }
}
