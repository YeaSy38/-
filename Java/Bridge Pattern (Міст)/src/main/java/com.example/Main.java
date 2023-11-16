package com.example;
// Implementor interface
interface CourseRecord {
    void recordGrade(String courseId, String grade);
}

// Concrete Implementor 1
class InternalCourseRecord implements CourseRecord {
    public void recordGrade(String courseId, String grade) {
        System.out.println("Internal course: " + courseId + ", Grade: " + grade);
    }
}

// Concrete Implementor 2
class ExternalCourseRecord implements CourseRecord {
    public void recordGrade(String courseId, String grade) {
        System.out.println("External course: " + courseId + ", Grade: " + grade);
    }
}

// Abstraction interface
interface Course {
    void recordGrade(String courseId, String grade);
}

// Refined Abstraction
class ProfessionalDevelopmentCourse implements Course {
    private CourseRecord courseRecord;

    public ProfessionalDevelopmentCourse(CourseRecord courseRecord) {
        this.courseRecord = courseRecord;
    }

    public void recordGrade(String courseId, String grade) {
        courseRecord.recordGrade(courseId, grade);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CourseRecord internalRecord = new InternalCourseRecord();
        CourseRecord externalRecord = new ExternalCourseRecord();

        Course professionalCourse1 = new ProfessionalDevelopmentCourse(internalRecord);
        professionalCourse1.recordGrade("Course1", "A");

        Course professionalCourse2 = new ProfessionalDevelopmentCourse(externalRecord);
        professionalCourse2.recordGrade("Course2", "B");
    }
}
