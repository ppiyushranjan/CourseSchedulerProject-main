package com.example.geektrust.Entities;

public class Registration extends BaseEntity {
    String email;
    String employeeName;
    Course course;
    
    public Registration(String email, String employeeName, Course course) {
        this.email = email;
        this.employeeName = employeeName;
        this.course = course;
    }

    public Registration(String id, String email, String employeeName, Course course) {
        this.id = id;
        this.email = email;
        this.employeeName = employeeName;
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Registration [id=" + id + ", email=" + email + ", employeeName=" + employeeName + ", course=" + course + "]";
    }

    
}
