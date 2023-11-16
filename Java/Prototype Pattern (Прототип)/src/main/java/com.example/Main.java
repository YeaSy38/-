package com.example;
import java.util.HashMap;
import java.util.Map;

// Course represents a professional development course
class Course implements Cloneable {
    private String name;
    
    public Course(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Course clone() throws CloneNotSupportedException {
        return (Course) super.clone();
    }
}

// CourseRegistry stores a collection of courses
class CourseRegistry {
    private Map<String, Course> courses;
    
    public CourseRegistry() {
        courses = new HashMap<>();
    }
    
    public void addCourse(String key, Course course) {
        courses.put(key, course);
    }
    
    public Course getCourse(String key) {
        Course course = null;
        try {
            course = courses.get(key).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return course;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a course registry
        CourseRegistry registry = new CourseRegistry();
        
        // Add courses to the registry
        Course course1 = new Course("Java Programming");
        registry.addCourse("1", course1);
        
        Course course2 = new Course("Web Development");
        registry.addCourse("2", course2);
        
        // Create a revised course based on a prototype
        Course revisedCourse1 = registry.getCourse("1");
        revisedCourse1.setName("Java Advanced Programming");
        System.out.println("Revised Course 1: " + revisedCourse1.getName());
        
        // Create another revised course based on the same prototype
        Course revisedCourse2 = registry.getCourse("1");
        revisedCourse2.setName("Java for Beginners");
        System.out.println("Revised Course 2: " + revisedCourse2.getName());
        
        // Original course remains unchanged
        System.out.println("Original Course: " + course1.getName());
    }
}
