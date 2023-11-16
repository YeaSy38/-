package com.example;
// Course interface
interface Course {
    void enroll();
}

// Concrete Course implementations
class JavaCourse implements Course {
    @Override
    public void enroll() {
        System.out.println("Enrolling in Java course...");
    }
}

class PythonCourse implements Course {
    @Override
    public void enroll() {
        System.out.println("Enrolling in Python course...");
    }
}

// Course factory interface
interface CourseFactory {
    Course createCourse();
}

// Concrete CourseFactory implementations
class JavaCourseFactory implements CourseFactory {
    @Override
    public Course createCourse() {
        return new JavaCourse();
    }
}

class PythonCourseFactory implements CourseFactory {
    @Override
    public Course createCourse() {
        return new PythonCourse();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create a Java course using the JavaCourseFactory
        CourseFactory javaCourseFactory = new JavaCourseFactory();
        Course javaCourse = javaCourseFactory.createCourse();
        javaCourse.enroll();

        // Create a Python course using the PythonCourseFactory
        CourseFactory pythonCourseFactory = new PythonCourseFactory();
        Course pythonCourse = pythonCourseFactory.createCourse();
        pythonCourse.enroll();
    }
}
