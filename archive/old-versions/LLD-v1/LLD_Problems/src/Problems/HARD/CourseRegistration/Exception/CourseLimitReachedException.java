package Problems.HARD.CourseRegistration.Exception;

public class CourseLimitReachedException extends RuntimeException{
    public CourseLimitReachedException(String message) {
        super(message);
    }
}
