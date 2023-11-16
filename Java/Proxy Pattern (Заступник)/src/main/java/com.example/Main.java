package com.example;
// Subject interface
interface Course {
    void enroll(String student);
    void complete(String student);
    void generateCertificate(String student);
}

// RealSubject class
class CourseImpl implements Course {
    private String courseName;

    public CourseImpl(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void enroll(String student) {
        System.out.println("Enrolling student " + student + " for " + courseName);
    }

    @Override
    public void complete(String student) {
        System.out.println("Completing course " + courseName + " for student " + student);
    }

    @Override
    public void generateCertificate(String student) {
        System.out.println("Generating certificate for student " + student + " for course " + courseName);
    }
}

// Proxy class
class CourseProxy implements Course {
    private String courseName;
    private CourseImpl course;

    public CourseProxy(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void enroll(String student) {
        if (course == null) {
            course = new CourseImpl(courseName);
        }
        course.enroll(student);
    }

    @Override
    public void complete(String student) {
        if (course == null) {
            course = new CourseImpl(courseName);
        }
        course.complete(student);
    }

    @Override
    public void generateCertificate(String student) {
        if (course == null) {
            course = new CourseImpl(courseName);
        }
        course.generateCertificate(student);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Course course = new CourseProxy("Java Programming");
        course.enroll("John");
        course.complete("John");
        course.generateCertificate("John");
    }
}
