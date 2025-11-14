package Problems.HARD.CourseRegistration.ServiceImpl;

import Problems.HARD.CourseRegistration.Model.Course;
import Problems.HARD.CourseRegistration.Model.Registration;
import Problems.HARD.CourseRegistration.Model.Student;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CourseRegistrationSystem {
    private static CourseRegistrationSystem instance;
    private final Map<String, Course> courses;
    private final Map<String, Student> students;
    private final List<Registration> registrationList;

    private CourseRegistrationSystem() {
        courses = new ConcurrentHashMap<>();
        students = new ConcurrentHashMap<>();
        registrationList = new CopyOnWriteArrayList<>();
    }

    public static synchronized CourseRegistrationSystem getInstance(){
        if(instance==null){
            instance = new CourseRegistrationSystem();
        }
        return instance;
    }

    public void addStudent(Student student){
        if(!students.containsKey(student.getId())){
            students.put(student.getId(), student);
        }
    }

    public void addCourse(Course course){
        if(!courses.containsKey(course.getCode())){
            courses.put(course.getCode(), course);
        }
    }

    public List<Course> searchCourse(String keyword){
        return courses.values().stream().filter(n->n.getCode().contains(keyword) ||
                n.getName().contains(keyword)).collect(Collectors.toList());
    }

    public synchronized boolean registerStudent(Student student, Course course){
        try{
            course.registerStudent(student);
            Registration registration = new Registration(generateRegistrationId(),student,course);
            registrationList.add(registration);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public List<Course> getRegisteredCourses(Student student){
        return student.getRegisteredCourses();
    }

    public List<Student> getRegisteredStudents(Course course){
        return course.getRegisteredStudents();
    }

    private String generateRegistrationId(){
        return "Reg"+ UUID.randomUUID().toString();
    }
}
