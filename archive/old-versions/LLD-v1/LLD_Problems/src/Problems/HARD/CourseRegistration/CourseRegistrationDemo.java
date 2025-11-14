package Problems.HARD.CourseRegistration;

import Problems.HARD.CourseRegistration.Model.Course;
import Problems.HARD.CourseRegistration.Model.Student;
import Problems.HARD.CourseRegistration.ServiceImpl.CourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

public class CourseRegistrationDemo {
    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = CourseRegistrationSystem.getInstance();

        // Create courses
        Course course1 = new Course("CS101", "Introduction to Programming", "John Doe", 10);
        Course course2 = new Course("CS201", "Data Structures and Algorithms", "Jane Smith", 1);
        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        // Create students
        Student student1 = new Student("1", "Alice", "alice@example.com");
        Student student2 = new Student("2", "Bob", "bob@example.com");
        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        // Search for courses
        List<Course> searchResults = registrationSystem.searchCourse("CS");
        System.out.println("Search Results:");
        for (Course course : searchResults) {
            System.out.println(course.getCode() + " - " + course.getName());
        }

        // Register courses for students
        boolean registered1 = registrationSystem.registerStudent(student1, course1);
        boolean registered2 = registrationSystem.registerStudent(student2, course1);

        boolean registered3 = registrationSystem.registerStudent(student1, course2);
        boolean registered4 = registrationSystem.registerStudent(student2, course2);

        System.out.println("Registration Results:");
        System.out.println("Student 1 - Course 1: " + registered1);
        System.out.println("Student 2 - Course 1: " + registered2);
        System.out.println("Student 1 - Course 2: " + registered3);
        System.out.println("Student 2 - Course 2: " + registered4);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(course1);
        System.out.println(course2);

    }
}
