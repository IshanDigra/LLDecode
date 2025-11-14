package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.Handler;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogLevel;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ChainOfResponsibility.LogMessage;

public class Handler {
    private Handler nextHandler;
    private LogLevel level;
    public Handler(LogLevel level) {
        this.level = level;
    }
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(LogMessage message){
        if(message.getLevel().equals(level)){
            System.out.println("Request handled!");
            System.out.println(message);
        }
        else if(nextHandler != null){
            nextHandler.handleRequest(message);
        }
    }
}
