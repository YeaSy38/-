package com.example;
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Course {
    void registerParticipant(Participant participant);
    void unregisterParticipant(Participant participant);
    void notifyParticipants();
}

// Concrete subject class
class CourseImpl implements Course {
    private List<Participant> participants = new ArrayList<>();

    public void registerParticipant(Participant participant) {
        participants.add(participant);
    }

    public void unregisterParticipant(Participant participant) {
        participants.remove(participant);
    }

    public void notifyParticipants() {
        for (Participant participant : participants) {
            participant.update();
        }
    }

    // Method to simulate a progress update in the course
    public void announceProgress(String progress) {
        System.out.println("Course progress: " + progress);
        notifyParticipants();
    }
}

// Observer interface
interface Participant {
    void update();
}

// Concrete observer class
class ParticipantImpl implements Participant {
    private Course course;
    private String name;

    public ParticipantImpl(String name, Course course) {
        this.name = name;
        this.course = course;
        course.registerParticipant(this);
    }

    public void update() {
        System.out.println(name + ": New progress announcement received");
    }
}

// Driver class
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create a new course
        CourseImpl course = new CourseImpl();

        // Create participants
        ParticipantImpl participant1 = new ParticipantImpl("John", course);
        ParticipantImpl participant2 = new ParticipantImpl("Sarah", course);

        // Announce progress updates
        course.announceProgress("Module 1 completed");
        course.announceProgress("Module 2 completed");

        // Unregister a participant
        course.unregisterParticipant(participant1);

        // Announce progress update again
        course.announceProgress("Module 3 completed");
    }
}
