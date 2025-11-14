package Problems.HARD.CourseRegistration.Model;

import java.sql.Timestamp;

public class Registration {
    private final String id ;
    private final Student student;
    private final Course course;
    private final Timestamp timestamp;

    public Registration(String id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id='" + id + '\'' +
                ", student=" + student.getName() +
                ", course=" + course.getName() +
                ", timestamp=" + timestamp +
                '}';
    }
}
