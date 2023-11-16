package com.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Interface for the courses collection
interface CoursesCollection {
    Iterator<String> createIterator();
}

// Concrete implementation of the courses collection
class PDCCoursesCollection implements CoursesCollection {
    private List<String> courses;

    public PDCCoursesCollection() {
        courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    @Override
    public Iterator<String> createIterator() {
        return new PDCCoursesIterator(courses);
    }
}

// Iterator that provides the iteration over the courses collection
class PDCCoursesIterator implements Iterator<String> {
    private List<String> courses;
    private int position;

    public PDCCoursesIterator(List<String> courses) {
        this.courses = courses;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < courses.size();
    }

    @Override
    public String next() {
        String course = courses.get(position);
        position++;
        return course;
    }
}

// Client code that uses the iterator to access the courses
public class Main {
    public static void main(String[] args) {
        CoursesCollection collection = new PDCCoursesCollection();
        collection.addCourse("Course 1");
        collection.addCourse("Course 2");
        collection.addCourse("Course 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            String course = iterator.next();
            System.out.println("Completed course: " + course);
        }
    }
}
