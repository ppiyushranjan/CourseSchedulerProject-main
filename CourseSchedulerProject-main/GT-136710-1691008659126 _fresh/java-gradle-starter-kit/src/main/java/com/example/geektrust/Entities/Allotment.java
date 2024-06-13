package com.example.geektrust.Entities;

public class Allotment extends BaseEntity {

    Course course;
    String allotmentStatus;

    public Allotment(Course course, String allotmentStatus) {
        this.course = course;
        this.allotmentStatus = allotmentStatus;
    }

    public Allotment(String id, Course course, String allotmentStatus) {
        this.id = id;
        this.course = course;
        this.allotmentStatus = allotmentStatus;
    }

    public Allotment(String id, Course course) {
        this.id = id;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getAllotmentStatus() {
        return allotmentStatus;
    }
    
    
}
