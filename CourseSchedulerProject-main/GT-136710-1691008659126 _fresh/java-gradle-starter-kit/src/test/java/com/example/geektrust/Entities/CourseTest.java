package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    List<String> tokens = new ArrayList<>();


    @BeforeEach
    public void setup(){
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");
    }

    @Test
    void getCourseName() {
        Course course  = new Course(tokens);

        String expected = "DATASCIENCE";

        assertEquals(expected, course.getCourseName());
    }

    @Test
    void getInstructor() {
        Course course  = new Course(tokens);

        String expected = "808";

        assertEquals(expected, course.getInstructor());
    }

    @Test
    void getDate() {
        Course course  = new Course(tokens);

        String expected = "05062022";

        assertEquals(expected, course.getDate());
    }

    @Test
    void getMin() {
        Course course  = new Course(tokens);

        int expected = 3;

        assertEquals(expected, course.getMin());
    }

    @Test
    void getMax() {
        Course course  = new Course(tokens);

        int expected = 5;

        assertEquals(expected, course.getMax());
    }

}