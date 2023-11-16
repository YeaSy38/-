package com.example;
import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface Mediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator
class CourseManagementSystem implements Mediator {
    private List<User> users;

    public CourseManagementSystem() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(User user, String message) {
        for (User u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}

// Colleague
abstract class User {
    protected Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}

// Concrete Colleague
class Student extends User {
    private String name;

    public Student(String name, Mediator mediator) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Student " + name + " received message: " + message);
    }
}

// Concrete Colleague
class Teacher extends User {
    private String name;

    public Teacher(String name, Mediator mediator) {
        super(mediator);
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Teacher " + name + " received message: " + message);
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        CourseManagementSystem system = new CourseManagementSystem();

        Teacher teacher = new Teacher("John Doe", system);
        Student student1 = new Student("Alice", system);
        Student student2 = new Student("Bob", system);

        system.addUser(teacher);
        system.addUser(student1);
        system.addUser(student2);

        teacher.sendMessage("Reminder: You have a course tomorrow.");
        student1.sendMessage("Thank you, teacher!");

        student2.sendMessage("I need to reschedule the course.");

        teacher.sendMessage("Sure, let's arrange a new date.");

    }
}
