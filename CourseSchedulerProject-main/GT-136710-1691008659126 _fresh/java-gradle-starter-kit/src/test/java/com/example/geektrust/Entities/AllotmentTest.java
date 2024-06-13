package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllotmentTest {
    List<String> tokens = new ArrayList<>();
    Course course;
    @BeforeEach
    void setup(){
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");
        course = new Course(tokens);
    }

    @Test
    void getCourse() {
        Allotment allotment = new Allotment(course, "CANCEL_ACCEPTED");

        Course actual = allotment.getCourse();

        assertEquals(course, actual);
    }

    @Test
    void getAllotmentStatus() {
        Allotment allotment = new Allotment(course, "CANCEL_ACCEPTED");
        String actual = allotment.getAllotmentStatus();

        assertEquals("CANCEL_ACCEPTED", actual);
    }
}