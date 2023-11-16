package com.example;
class Course {
    private String name;
    private String instructor;
    private int duration;
    private double price;
    
    private Course(Builder builder) {
        this.name = builder.name;
        this.instructor = builder.instructor;
        this.duration = builder.duration;
        this.price = builder.price;
    }
    
    // Getters for the course attributes
    
    public String getName() {
        return name;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public double getPrice() {
        return price;
    }
    
    static class Builder {
        private String name;
        private String instructor;
        private int duration;
        private double price;
        
        public Builder() {
            // Set default values if needed
        }
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setInstructor(String instructor) {
            this.instructor = instructor;
            return this;
        }
        
        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        
        public Course build() {
            return new Course(this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Course course = new Course.Builder()
                .setName("Java Fundamentals")
                .setInstructor("John Doe")
                .setDuration(30)
                .setPrice(99.99)
                .build();
        
        System.out.println("Course Name: " + course.getName());
        System.out.println("Instructor: " + course.getInstructor());
        System.out.println("Duration: " + course.getDuration() + " days");
        System.out.println("Price: $" + course.getPrice());
    }
}
