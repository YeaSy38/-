package com.example;
// Subsystem 1: Course Registration
class CourseRegistrationSystem {
    public void registerCourse(String courseName) {
        System.out.println("Registered for course: " + courseName);
    }
}

// Subsystem 2: Course Attendance
class CourseAttendanceSystem {
    public void markAttendance(String courseName, String student) {
        System.out.println(student + " marked attendance for course: " + courseName);
    }
}

// Subsystem 3: Course Grading
class CourseGradingSystem {
    public void gradeCourse(String courseName, String student) {
        System.out.println("Graded course: " + courseName + " for " + student);
    }
}

// Facade: Course Management System
class CourseManagementSystem {
    private CourseRegistrationSystem registrationSystem;
    private CourseAttendanceSystem attendanceSystem;
    private CourseGradingSystem gradingSystem;

    public CourseManagementSystem() {
        this.registrationSystem = new CourseRegistrationSystem();
        this.attendanceSystem = new CourseAttendanceSystem();
        this.gradingSystem = new CourseGradingSystem();
    }

    public void enrollCourse(String courseName, String student) {
        registrationSystem.registerCourse(courseName);
        attendanceSystem.markAttendance(courseName, student);
        gradingSystem.gradeCourse(courseName, student);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CourseManagementSystem courseManagementSystem = new CourseManagementSystem();

        // Using the facade to enroll a course for a student
        courseManagementSystem.enrollCourse("Java Programming", "John Doe");
    }
}
