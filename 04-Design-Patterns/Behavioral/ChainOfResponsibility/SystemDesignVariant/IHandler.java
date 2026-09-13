package SystemDesign.ChainOfResponsibility;

public interface IHandler {
    Boolean processMessage(Message msg);
}
