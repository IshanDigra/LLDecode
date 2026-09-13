package SystemDesign.ChainOfResponsibility;

public class EmailHandler implements IHandler{

    IHandler nextHandler;

    public EmailHandler(IHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    @Override
    public Boolean processMessage(Message msg) {
        if(msg.text.contains("Email")){
            System.out.println("EmailErrorHandler processed "+ msg.priority + " priority issue: " + msg.text);
            return true;
        }
        else{
            if(nextHandler != null){
                nextHandler.processMessage(msg);
            }
        }
        return false;
    }
}
