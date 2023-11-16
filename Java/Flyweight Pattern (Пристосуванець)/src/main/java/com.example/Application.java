package com.example;
import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Course {
    void enroll(String participant);
}

// Concrete flyweight
class OnlineCourse implements Course {
    private String title;

    public OnlineCourse(String title) {
        this.title = title;
    }

    @Override
    public void enroll(String participant) {
        System.out.println(participant + " enrolled in the online course: " + title);
    }
}

// Flyweight factory
class CourseFactory {
    private Map<String, Course> courses;

    public CourseFactory() {
        courses = new HashMap<>();
    }

    public Course getCourse(String title) {
        Course course = courses.get(title);

        if (course == null) {
            course = new OnlineCourse(title);
            courses.put(title, course);
            System.out.println("Creating new online course: " + title);
        }

        return course;
    }
}

// Client class
public class Application {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();

        // Enroll participants in courses
        Course course1 = courseFactory.getCourse("Java Fundamentals");
        course1.enroll("John Doe");

        Course course2 = courseFactory.getCourse("Java Fundamentals");
        course2.enroll("Jane Smith");

        Course course3 = courseFactory.getCourse("Advanced Java");
        course3.enroll("Adam Johnson");

        Course course4 = courseFactory.getCourse("Advanced Java");
        course4.enroll("Emily Brown");
    }
}
