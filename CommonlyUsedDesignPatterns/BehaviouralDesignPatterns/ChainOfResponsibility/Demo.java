package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler.Debug;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler.Error;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler.Handler;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler.Warning;

public class Demo {
    public static void main(String[] args) {
        Handler h1 = new Debug(LogLevel.DEBUG);
        Handler h2 = new Warning(LogLevel.WARNING);
        Handler h3 = new Error(LogLevel.ERROR);

        h1.setNextHandler(h2);
        h2.setNextHandler(h3);

        LogMessage l1 = new LogMessage(LogLevel.DEBUG,"debug message");
        LogMessage l2 = new LogMessage(LogLevel.WARNING,"warning message");
        LogMessage l3 = new LogMessage(LogLevel.ERROR,"error message");
        h1.handleRequest(l1);
        h1.handleRequest(l2);
        h1.handleRequest(l3);
    }
}
