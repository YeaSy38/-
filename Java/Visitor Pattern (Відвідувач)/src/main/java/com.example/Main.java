package com.example;
// Define the Visitable interface for courses
interface CourseVisitable {
    void accept(CourseVisitor visitor);
}

// Concrete class for a course
class Course implements CourseVisitable {
    private String title;
    private int duration;

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void accept(CourseVisitor visitor) {
        visitor.visit(this);
    }
}

// Define the Visitor interface
interface CourseVisitor {
    void visit(Course course);
}

// Concrete class for visitor implementation
class CourseCompletionVisitor implements CourseVisitor {
    private int totalDuration;

    public CourseCompletionVisitor() {
        totalDuration = 0;
    }

    @Override
    public void visit(Course course) {
        totalDuration += course.getDuration();
        System.out.println("Completed course: " + course.getTitle());
    }

    public int getTotalDuration() {
        return totalDuration;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create courses
        Course course1 = new Course("Java Programming", 40);
        Course course2 = new Course("Database Management", 30);
        Course course3 = new Course("Web Development", 50);

        // Create visitor
        CourseVisitor visitor = new CourseCompletionVisitor();

        // Accept visitor for each course
        course1.accept(visitor);
        course2.accept(visitor);
        course3.accept(visitor);

        // Get total duration of completed courses
        int totalDuration = ((CourseCompletionVisitor) visitor).getTotalDuration();
        System.out.println("Total duration of completed courses: " + totalDuration);
    }
}
