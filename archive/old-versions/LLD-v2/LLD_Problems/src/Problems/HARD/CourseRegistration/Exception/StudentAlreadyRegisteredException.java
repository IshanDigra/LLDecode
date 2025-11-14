package Problems.HARD.CourseRegistration.Exception;

public class StudentAlreadyRegisteredException extends RuntimeException{
    public StudentAlreadyRegisteredException(String message) {
        super(message);
    }
}
