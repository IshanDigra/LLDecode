package Problems.HARD.CourseRegistration.Model;

import Problems.HARD.CourseRegistration.Exception.CourseLimitReachedException;
import Problems.HARD.CourseRegistration.Exception.StudentAlreadyRegisteredException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Course {
    private final String code;
    private final String name;
    private final String instructor;
    private final int maximumCapacity;
    private int currentCapacity;
    private Map<String, Student> registeredStudents;

    public Course(String code, String name, String instructor, int maximumCapacity) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
        this.maximumCapacity = maximumCapacity;
        currentCapacity = 0 ;
        registeredStudents = new ConcurrentHashMap<>();
    }

    public synchronized void registerStudent(Student student){
        if(currentCapacity < maximumCapacity){
            if(!registeredStudents.containsKey(student.getId())){
                registeredStudents.put(student.getId(),student);
                student.addCourse(this);
                currentCapacity++;
            }
            else{
                throw new StudentAlreadyRegisteredException("Student is already registered for this course.");
            }
        }
        else{
            throw new CourseLimitReachedException(code + " has reached its maximum capacity!");
        }
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents.values().stream().toList();
    }

    public void setRegisteredStudents(Map<String, Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", maximumCapacity=" + maximumCapacity +
                ", currentCapacity=" + currentCapacity +
                ", registeredStudents= {" + registeredStudents.values().stream().map(n->n.getName()).collect(Collectors.joining(", "))+"}" +
                '}';
    }
}
