package SystemDesign.ChainOfResponsibility;

public class ChainOfResponsibilityRunner {
    public static void main(String[] args){
        IHandler faxHandler, emailHandler;


//end of chain
        emailHandler = new EmailHandler(null);
//fax handler is before email
        faxHandler = new FaxHandler(emailHandler);

        IssueRaiser raiser = new IssueRaiser(faxHandler);
//starting point: raiser will raise issues and set the first handler IssueRaiser raiser = new IssueRaiser (faxHandler);
        Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.normal);
        Message m2 = new Message("Email is not going", MessagePriority.high);
        Message m3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.normal);
        Message m4 = new Message("Fax is not reaching destination", MessagePriority.high);
        raiser.raiseIssue(m1);
        raiser.raiseIssue(m2);
        raiser.raiseIssue(m3);
        raiser.raiseIssue(m4);
    }
}
