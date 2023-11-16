package com.example;
// Component interface
interface Course {
    void enroll(String participant);
    void complete(String participant);
}

// Concrete component class
class ProfessionalCourse implements Course {
    private final String name;

    public ProfessionalCourse(String name) {
        this.name = name;
    }

    @Override
    public void enroll(String participant) {
        System.out.println(participant + " enrolled in " + name);
    }

    @Override
    public void complete(String participant) {
        System.out.println(participant + " completed " + name);
    }
}

// Decorator abstract class
abstract class CourseDecorator implements Course {
    protected final Course decoratedCourse;

    public CourseDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public void enroll(String participant) {
        decoratedCourse.enroll(participant);
    }

    @Override
    public void complete(String participant) {
        decoratedCourse.complete(participant);
    }
}

// Concrete decorator class
class CourseWithCertificate extends CourseDecorator {
    public CourseWithCertificate(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public void complete(String participant) {
        decoratedCourse.complete(participant);
        System.out.println(participant + " received a certificate for completing the course.");
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        // Create a professional course
        Course professionalCourse = new ProfessionalCourse("Java Programming");

        // Decorate the course with a certificate
        Course decoratedCourse = new CourseWithCertificate(professionalCourse);

        // Enroll and complete the course
        String participant = "John Smith";
        decoratedCourse.enroll(participant);
        decoratedCourse.complete(participant);
    }
}
