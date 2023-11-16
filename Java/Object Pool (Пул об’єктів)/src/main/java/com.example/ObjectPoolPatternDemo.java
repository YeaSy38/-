package com.example;
import java.util.ArrayList;
import java.util.List;

// Course class represents a professional development course
class Course {
    private String title;
    
    public Course(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void complete(String participant) {
        System.out.println(participant + " has completed the course: " + title);
    }
}

// Object Pool class manages the available courses
class CoursePool {
    private int maxPoolSize;
    private List<Course> availableCourses;
    private List<Course> borrowedCourses;
    
    public CoursePool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.availableCourses = new ArrayList<>();
        this.borrowedCourses = new ArrayList<>();
    }
    
    public Course borrowCourse() {
        if (availableCourses.isEmpty()) {
            if (borrowedCourses.size() < maxPoolSize) {
                Course newCourse = new Course("New Course");
                borrowedCourses.add(newCourse);
                return newCourse;
            } else {
                return null; // No available courses and pool limit reached
            }
        } else {
            Course course = availableCourses.remove(0);
            borrowedCourses.add(course);
            return course;
        }
    }
    
    public void returnCourse(Course course) {
        if (borrowedCourses.remove(course)) {
            availableCourses.add(course);
        }
    }
}

public class ObjectPoolPatternDemo {

    public static void main(String[] args) {
        CoursePool coursePool = new CoursePool(5); // Maximum pool size is 5 courses
        
        Course course1 = coursePool.borrowCourse();
        if (course1 != null) {
            course1.complete("John");
            coursePool.returnCourse(course1);
        }
        
        Course course2 = coursePool.borrowCourse();
        if (course2 != null) {
            course2.complete("Jane");
            coursePool.returnCourse(course2);
        }
        
        Course course3 = coursePool.borrowCourse();
        if (course3 != null) {
            course3.complete("Bob");
            coursePool.returnCourse(course3);
        }
        
        Course course4 = coursePool.borrowCourse();
        if (course4 != null) {
            course4.complete("Alice");
            coursePool.returnCourse(course4);
        }
        
        Course course5 = coursePool.borrowCourse();
        if (course5 != null) {
            course5.complete("Mike");
            coursePool.returnCourse(course5);
        }
        
        Course course6 = coursePool.borrowCourse(); // Try to borrow an unavailable course
        if (course6 != null) {
            course6.complete("Sam");
            coursePool.returnCourse(course6);
        } else {
            System.out.println("No available courses at the moment. Please try again later.");
        }
    }

}
