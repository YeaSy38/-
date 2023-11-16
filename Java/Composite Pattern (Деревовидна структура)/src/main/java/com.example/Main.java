package com.example;
import java.util.ArrayList;
import java.util.List;

interface CourseComponent {
    void add(CourseComponent component);
    void remove(CourseComponent component);
    void display(int depth);
}

class Course implements CourseComponent {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    // Implementing CourseComponent methods
    @Override
    public void add(CourseComponent component) {
        // Cannot add component to a course object
        System.out.println("Cannot add to a course.");
    }

    @Override
    public void remove(CourseComponent component) {
        // Cannot remove component from a course object
        System.out.println("Cannot remove from a course.");
    }

    @Override
    public void display(int depth) {
        // Displaying course name at a certain depth
        System.out.println("-".repeat(depth) + name);
    }
}

class CourseSet implements CourseComponent {
    private String name;
    private List<CourseComponent> components;

    public CourseSet(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    // Implementing CourseComponent methods
    @Override
    public void add(CourseComponent component) {
        components.add(component);
    }

    @Override
    public void remove(CourseComponent component) {
        components.remove(component);
    }

    @Override
    public void display(int depth) {
        // Displaying course set name at a certain depth
        System.out.println("-".repeat(depth) + name);

        // Displaying components of the course set recursively
        for (CourseComponent component : components) {
            component.display(depth + 2);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating courses
        CourseComponent javaCourse = new Course("Java Programming Course");
        CourseComponent pythonCourse = new Course("Python Programming Course");

        // Creating course sets
        CourseComponent programmingSet = new CourseSet("Programming Courses");
        CourseComponent dataScienceSet = new CourseSet("Data Science Courses");

        // Adding courses to the course sets
        programmingSet.add(javaCourse);
        programmingSet.add(pythonCourse);
        dataScienceSet.add(new Course("Machine Learning Course"));

        // Adding course sets to another course set
        CourseComponent rootSet = new CourseSet("Root Set");
        rootSet.add(programmingSet);
        rootSet.add(dataScienceSet);

        // Displaying the tree structure
        rootSet.display(0);
    }
}
