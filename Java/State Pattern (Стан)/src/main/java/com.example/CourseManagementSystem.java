package com.example;
// Interface for the states
interface CourseState {
    void enrollCourse();
    void startCourse();
    void completeCourse();
    void cancelCourse();
}

// Concrete states
class CourseEnrollmentState implements CourseState {
    @Override
    public void enrollCourse() {
        System.out.println("The course is already enrolled.");
    }

    @Override
    public void startCourse() {
        System.out.println("Starting the course.");
    }

    @Override
    public void completeCourse() {
        System.out.println("The course cannot be completed, it needs to be started first.");
    }

    @Override
    public void cancelCourse() {
        System.out.println("Cancelling the course enrollment.");
    }
}

class CourseInProgressState implements CourseState {
    @Override
    public void enrollCourse() {
        System.out.println("The course is already in progress.");
    }

    @Override
    public void startCourse() {
        System.out.println("The course is already started.");
    }

    @Override
    public void completeCourse() {
        System.out.println("Completing the course.");
    }

    @Override
    public void cancelCourse() {
        System.out.println("Cancelling the course in progress.");
    }
}

class CourseCompletedState implements CourseState {
    @Override
    public void enrollCourse() {
        System.out.println("The course is already completed, cannot enroll again.");
    }

    @Override
    public void startCourse() {
        System.out.println("The course is already completed, cannot start again.");
    }

    @Override
    public void completeCourse() {
        System.out.println("The course is already completed.");
    }

    @Override
    public void cancelCourse() {
        System.out.println("Cannot cancel the completed course.");
    }
}

// Context class
class Course {
    private CourseState currentState;

    public Course() {
        currentState = new CourseEnrollmentState();
    }

    public void setState(CourseState state) {
        currentState = state;
    }

    public void enroll() {
        currentState.enrollCourse();
    }

    public void start() {
        currentState.startCourse();
    }

    public void complete() {
        currentState.completeCourse();
    }

    public void cancel() {
        currentState.cancelCourse();
    }
}

// Main class
public class CourseManagementSystem {
    public static void main(String[] args) {
        Course course = new Course();

        course.enroll(); // Output: The course is already enrolled.

        course.start(); // Output: Starting the course.

        course.complete(); // Output: The course cannot be completed, it needs to be started first.

        course.cancel(); // Output: Cancelling the course enrollment.

        course.start(); // Output: The course is already started.

        course.complete(); // Output: Completing the course.

        course.enroll(); // Output: The course is already completed, cannot enroll again.

        course.cancel(); // Output: Cannot cancel the completed course.
    }
}
