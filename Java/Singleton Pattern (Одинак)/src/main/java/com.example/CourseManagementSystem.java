package com.example;
public class CourseManagementSystem {
    private static CourseManagementSystem instance;

    // Private constructor to prevent instantiation outside the class
    private CourseManagementSystem() {
        // Initialization code goes here
    }

    // Method to get the singleton instance
    public static CourseManagementSystem getInstance() {
        if (instance == null) {
            synchronized (CourseManagementSystem.class) {
                if (instance == null) {
                    instance = new CourseManagementSystem();
                }
            }
        }
        return instance;
    }

    // Other methods and functionality of the system
    public void enrollCourse(String courseName) {
        System.out.println("Enrolling in course: " + courseName);
        // Business logic for enrolling in a course
    }

    public void completeCourse(String courseName) {
        System.out.println("Completing course: " + courseName);
        // Business logic for completing a course
    }

    public void generateReport() {
        System.out.println("Generating report");
        // Business logic for generating reports
    }

    // Main method for testing
    public static void main(String[] args) {
        CourseManagementSystem system = CourseManagementSystem.getInstance();

        system.enrollCourse("Java Programming");
        system.enrollCourse("Database Management");
        
        system.completeCourse("Java Programming");
        
        system.generateReport();
    }
}
