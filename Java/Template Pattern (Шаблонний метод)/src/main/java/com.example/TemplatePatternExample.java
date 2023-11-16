package com.example;
import java.util.ArrayList;
import java.util.List;

// Abstract class representing a course
abstract class Course {
    protected String courseName;
    protected List<String> courseContent;
    
    public Course(String courseName) {
        this.courseName = courseName;
        this.courseContent = new ArrayList<>();
    }
    
    // Template method that defines the overall structure of the course
    public final void createCourse() {
        System.out.println("Creating course: " + courseName);
        
        prepareCourseMaterials();
        createCourseContent();
        conductAssessment();
        generateCertificate();
        
        System.out.println("Course creation completed.");
    }
    
    // Abstract methods to be implemented by subclasses
    protected abstract void prepareCourseMaterials();
    protected abstract void createCourseContent();
    protected abstract void conductAssessment();
    
    // Common implementation for generating certificate
    protected void generateCertificate() {
        System.out.println("Generating certificate for " + courseName);
    }
}

// Concrete implementation of a specific course
class JavaCourse extends Course {
    public JavaCourse(String courseName) {
        super(courseName);
    }
    
    @Override
    protected void prepareCourseMaterials() {
        System.out.println("Preparing Java course materials");
    }
    
    @Override
    protected void createCourseContent() {
        courseContent.add("Introduction to Java");
        courseContent.add("Variables and Data Types");
        courseContent.add("Control Statements");
        
        System.out.println("Creating Java course content");
    }
    
    @Override
    protected void conductAssessment() {
        System.out.println("Conducting assessment for Java course");
    }
}

// Concrete implementation of another course
class WebDevelopmentCourse extends Course {
    public WebDevelopmentCourse(String courseName) {
        super(courseName);
    }
    
    @Override
    protected void prepareCourseMaterials() {
        System.out.println("Preparing Web Development course materials");
    }
    
    @Override
    protected void createCourseContent() {
        courseContent.add("HTML and CSS");
        courseContent.add("JavaScript");
        courseContent.add("Backend Development");
        
        System.out.println("Creating Web Development course content");
    }
    
    @Override
    protected void conductAssessment() {
        System.out.println("Conducting assessment for Web Development course");
    }
}

// Main class to test the program
public class TemplatePatternExample {
    public static void main(String[] args) {
        Course javaCourse = new JavaCourse("Java Programming Course");
        javaCourse.createCourse();
        
        System.out.println();
        
        Course webDevCourse = new WebDevelopmentCourse("Web Development Course");
        webDevCourse.createCourse();
    }
}
