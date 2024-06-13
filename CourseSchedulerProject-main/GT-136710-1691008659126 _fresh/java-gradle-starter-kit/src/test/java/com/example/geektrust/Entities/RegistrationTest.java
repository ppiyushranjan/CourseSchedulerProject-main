package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    List<String> tokens = new ArrayList<>();
    Course course;
    @BeforeEach
    void setup(){
        tokens.add("ANDY@GMAIL.COM");
        tokens.add("OFFERING-DATASCIENCE-BOB");

        List<String> courseTokens = new ArrayList<>();
        courseTokens.add("ADD-COURSE-OFFERING");
        courseTokens.add("DATASCIENCE");
        courseTokens.add("808");
        courseTokens.add("05062022");
        courseTokens.add("3");
        courseTokens.add("5");
        course = new Course(courseTokens);
    }

    @Test
    void getEmail() {
        Registration registration = new Registration(tokens.get(0), tokens.get(1), course);

        String expected = "ANDY@GMAIL.COM";

        assertEquals(expected, registration.getEmail());
    }

    @Test
    void getEmployeeName() {
        Registration registration = new Registration(tokens.get(0), tokens.get(1), course);

        String expected = "OFFERING-DATASCIENCE-BOB";

        assertEquals(expected, registration.getEmployeeName());
    }

    @Test
    void getCourse() {
        Registration registration = new Registration(tokens.get(0), tokens.get(1), course);
        Course actual = registration.getCourse();
        assertEquals(course, actual);
    }

}