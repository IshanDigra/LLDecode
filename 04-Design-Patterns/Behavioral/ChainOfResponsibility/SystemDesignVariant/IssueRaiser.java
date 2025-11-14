package SystemDesign.ChainOfResponsibility;

public class IssueRaiser {
    IHandler ErrorHandler;
    public IssueRaiser(IHandler ErrorHandler){
        this.ErrorHandler = ErrorHandler;
    }

    public void raiseIssue(Message msg){
        if(ErrorHandler!=  null){
            ErrorHandler.processMessage(msg);
        }
    }
}
