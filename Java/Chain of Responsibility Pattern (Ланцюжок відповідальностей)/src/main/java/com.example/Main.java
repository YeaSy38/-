package com.example;
// Handler interface
interface CourseHandler {
    void setNextHandler(CourseHandler nextHandler);
    void processCourse(Course course);
}

// Concrete Handler: Course Registration Handler
class CourseRegistrationHandler implements CourseHandler {
    private CourseHandler nextHandler;

    @Override
    public void setNextHandler(CourseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processCourse(Course course) {
        if (course.isRegistrationRequired()) {
            System.out.println("Registering for course: " + course.getName());
        }

        if (nextHandler != null) {
            nextHandler.processCourse(course);
        }
    }
}

// Concrete Handler: Course Completion Handler
class CourseCompletionHandler implements CourseHandler {
    private CourseHandler nextHandler;

    @Override
    public void setNextHandler(CourseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processCourse(Course course) {
        if (course.isCompleted()) {
            System.out.println("Completing course: " + course.getName());
        }

        if (nextHandler != null) {
            nextHandler.processCourse(course);
        }
    }
}

// Course class
class Course {
    private String name;
    private boolean registrationRequired;
    private boolean completed;

    public Course(String name, boolean registrationRequired, boolean completed) {
        this.name = name;
        this.registrationRequired = registrationRequired;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public boolean isCompleted() {
        return completed;
    }
}

// Client class
public class Main {
    public static void main(String[] args) {
        // Creating the chain of responsibility
        CourseHandler registrationHandler = new CourseRegistrationHandler();
        CourseHandler completionHandler = new CourseCompletionHandler();

        registrationHandler.setNextHandler(completionHandler);

        // Creating courses
        Course course1 = new Course("Course 1", true, true);
        Course course2 = new Course("Course 2", false, false);
        Course course3 = new Course("Course 3", true, false);

        // Processing courses through the chain
        registrationHandler.processCourse(course1);
        System.out.println("------------------");
        registrationHandler.processCourse(course2);
        System.out.println("------------------");
        registrationHandler.processCourse(course3);
    }
}
