package com.example.geektrust.repositories;

import com.example.geektrust.Entities.Allotment;
import com.example.geektrust.Entities.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AllotmentRepositoryTest {
    Allotment allotment;
    IAllotmentRepository allotmentRepository = new AllotmentRepository();

    @BeforeEach
    void setup(){
        Course course;
        List<String> tokens = new ArrayList<>();
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");
        course = new Course(tokens);
        allotment= new Allotment(course, "CANCEL_ACCEPTED");
    }


    @Test
    void save() {
        Allotment actual = allotmentRepository.save(allotment);
        assertEquals(allotment.getAllotmentStatus(), actual.getAllotmentStatus());
        assertEquals(allotment.getCourse(), actual.getCourse());
    }

    @Test
    void findAll() {
        allotmentRepository.save(allotment);

        List<Allotment> actual = allotmentRepository.findAll();

        assertEquals(1, actual.size());
    }

    @Test
    void findById() {
        allotmentRepository.save(allotment);

        Optional<Allotment> actual = allotmentRepository.findById("1");


        assertEquals(actual.get().getAllotmentStatus(), "CANCEL_ACCEPTED");
    }
}