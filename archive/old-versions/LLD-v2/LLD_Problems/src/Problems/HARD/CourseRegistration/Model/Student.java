package Problems.HARD.CourseRegistration.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Student {
    private final String id;
    private final String name;
    private final String email;
    private List<Course> registeredCourses;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        registeredCourses = new CopyOnWriteArrayList<>();
    }

    public void addCourse(Course course){
        registeredCourses.add(course);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registeredCourses= {" + registeredCourses.stream().map(n->n.getCode()+" : "+ n.getName()+" - By Prof. "+n.getInstructor()).collect(Collectors.joining(", ")) +"}"+
                '}';
    }
}
