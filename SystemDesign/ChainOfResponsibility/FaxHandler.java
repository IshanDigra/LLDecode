package SystemDesign.ChainOfResponsibility;

public class FaxHandler implements IHandler{

    IHandler nextHandler;

    public FaxHandler(IHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    @Override
    public Boolean processMessage(Message msg) {
        if(msg.text.contains("Fax")){
            System.out.println("FaxErrorHandler processed "+ msg.priority + " priority issue: " + msg.text);
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
