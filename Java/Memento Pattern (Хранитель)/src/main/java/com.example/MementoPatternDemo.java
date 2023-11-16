package com.example;
import java.util.ArrayList;
import java.util.List;

// Originator class
class Course {
    private String name;
    private int progress;

    public Course(String name) {
        this.name = name;
        this.progress = 0;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Memento save() {
        return new Memento(progress);
    }

    public void restore(Memento memento) {
        this.progress = memento.getProgress();
    }

    @Override
    public String toString() {
        return "Course: " + name + ", Progress: " + progress;
    }
}

// Memento class
class Memento {
    private int progress;

    public Memento(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}

// Caretaker class
class CourseCaretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}

// Client class
public class MementoPatternDemo {
    public static void main(String[] args) {
        Course course = new Course("Java Programming");

        CourseCaretaker caretaker = new CourseCaretaker();
        caretaker.addMemento(course.save()); // Save current progress

        course.setProgress(50); // Update progress
        caretaker.addMemento(course.save()); // Save current progress

        course.setProgress(100); // Update progress
        caretaker.addMemento(course.save()); // Save current progress

        System.out.println(course);

        course.restore(caretaker.getMemento(1)); // Restore previous progress
        System.out.println(course);

        course.restore(caretaker.getMemento(0)); // Restore initial progress
        System.out.println(course);
    }
}
