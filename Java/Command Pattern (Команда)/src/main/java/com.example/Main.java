package com.example;
// Interface for the command
interface Command {
    void execute();
}

// Concrete command classes
class AddCourseCommand implements Command {
    private final CourseManager courseManager;

    public AddCourseCommand(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    @Override
    public void execute() {
        courseManager.addCourse();
    }
}

class RemoveCourseCommand implements Command {
    private final CourseManager courseManager;

    public RemoveCourseCommand(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    @Override
    public void execute() {
        courseManager.removeCourse();
    }
}

class UpdateCourseCommand implements Command {
    private final CourseManager courseManager;

    public UpdateCourseCommand(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    @Override
    public void execute() {
        courseManager.updateCourse();
    }
}

// Receiver
class CourseManager {
    public void addCourse() {
        System.out.println("Course added.");
    }

    public void removeCourse() {
        System.out.println("Course removed.");
    }

    public void updateCourse() {
        System.out.println("Course updated.");
    }
}

// Invoker
class CourseInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();

        Command addCommand = new AddCourseCommand(courseManager);
        Command removeCommand = new RemoveCourseCommand(courseManager);
        Command updateCommand = new UpdateCourseCommand(courseManager);

        CourseInvoker invoker = new CourseInvoker();

        invoker.setCommand(addCommand);
        invoker.executeCommand();

        invoker.setCommand(removeCommand);
        invoker.executeCommand();

        invoker.setCommand(updateCommand);
        invoker.executeCommand();
    }
}
