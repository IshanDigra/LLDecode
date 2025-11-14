package Problems.HARD.Chess.Exception;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(final String message){
        super(message);
    }
}
