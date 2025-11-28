package V2.Entities;


import V2.Entities.Handler.*;

public class LoggingFrameWork extends Handler {
    private static volatile LoggingFrameWork instance;
    private LoggingFrameWork() {
        Handler h1 = new DebugHandler();
        Handler h2 = new InfoHandler();
        Handler h3 = new WarningHandler();
        Handler h4 = new ErrorHandler();

        this.setNextHandler(h1);
        h1.setNextHandler(h2);
        h2.setNextHandler(h3);
        h3.setNextHandler(h4);
    }

    public static LoggingFrameWork getInstance(){
        if(instance==null){
            synchronized (LoggingFrameWork.class){
                if(instance==null){
                    instance = new LoggingFrameWork();
                }
            }
        }
        return instance;
    }

    public void processLog(LogMessage message){
        try{
            super.processLog(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
