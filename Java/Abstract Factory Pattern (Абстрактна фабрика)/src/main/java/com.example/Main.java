package com.example;
// Abstract Factory Pattern Example

// Abstract factory interface
interface CourseFactory {
    Course createCourse();
    Certificate createCertificate();
}

// Concrete factory 1
class ITCourseFactory implements CourseFactory {
    public Course createCourse() {
        return new ITCourse();
    }

    public Certificate createCertificate() {
        return new ITCertificate();
    }
}

// Concrete factory 2
class FinanceCourseFactory implements CourseFactory {
    public Course createCourse() {
        return new FinanceCourse();
    }
 
    public Certificate createCertificate() {
        return new FinanceCertificate();
    }
}

// Abstract product 1
interface Course {
    void enroll();
    void study();
}

// Concrete product 1
class ITCourse implements Course {
    public void enroll() {
        System.out.println("Enrolling in IT course...");
    }

    public void study() {
        System.out.println("Studying IT course...");
    }
}

// Abstract product 2
interface Certificate {
    void generate();
}

// Concrete product 2
class ITCertificate implements Certificate {
    public void generate() {
        System.out.println("Generating IT certificate...");
    }
}

// Concrete product 3
class FinanceCertificate implements Certificate {
    public void generate() {
        System.out.println("Generating finance certificate...");
    }
}

// Concrete product 4
class FinanceCourse implements Course {
    public void enroll() {
        System.out.println("Enrolling in finance course...");
    }

    public void study() {
        System.out.println("Studying finance course...");
    }
}

// Client class
public class Main {
    public static void main(String[] args) {
        // Using an IT course factory
        CourseFactory itFactory = new ITCourseFactory();
        Course itCourse = itFactory.createCourse();
        Certificate itCertificate = itFactory.createCertificate();

        itCourse.enroll();
        itCourse.study();
        itCertificate.generate();

        // Using a finance course factory
        CourseFactory financeFactory = new FinanceCourseFactory();
        Course financeCourse = financeFactory.createCourse();
        Certificate financeCertificate = financeFactory.createCertificate();

        financeCourse.enroll();
        financeCourse.study();
        financeCertificate.generate();
    }
}
