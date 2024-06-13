package com.example.geektrust.Entities;

import java.util.ArrayList;
import java.util.List;

public class Course extends BaseEntity {
    String courseName;
    String instructor;
    String date;
    int min;
    int max;
    List<Registration> registrations = new ArrayList<>();

    // Define named constants for the token positions
    private static final int COURSE_NAME_TOKEN_INDEX = 1;
    private static final int INSTRUCTOR_TOKEN_INDEX = 2;
    private static final int DATE_TOKEN_INDEX = 3;
    private static final int MIN_TOKEN_INDEX = 4;
    private static final int MAX_TOKEN_INDEX = 5;
    
    public Course(List<String> tokens) {
        this.courseName = tokens.get(COURSE_NAME_TOKEN_INDEX);
        this.instructor = tokens.get(INSTRUCTOR_TOKEN_INDEX);
        this.date = tokens.get(DATE_TOKEN_INDEX);
        this.min = Integer.parseInt(tokens.get(MIN_TOKEN_INDEX));
        this.max = Integer.parseInt(tokens.get(MAX_TOKEN_INDEX));
    }

    public Course(String id, List<String> tokens) {
        this.id = id;
        this.courseName = tokens.get(COURSE_NAME_TOKEN_INDEX);
        this.instructor = tokens.get(INSTRUCTOR_TOKEN_INDEX);
        this.date = tokens.get(DATE_TOKEN_INDEX);
        this.min = Integer.parseInt(tokens.get(MIN_TOKEN_INDEX));
        this.max = Integer.parseInt(tokens.get(MAX_TOKEN_INDEX));
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDate() {
        return date;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }
    
    
}
