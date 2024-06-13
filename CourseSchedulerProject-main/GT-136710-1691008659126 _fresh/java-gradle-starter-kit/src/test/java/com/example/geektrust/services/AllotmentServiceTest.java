package com.example.geektrust.services;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.Entities.Registration;
import com.example.geektrust.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllotmentServiceTest {
    IAllotmentRepository allotmentRepository = new AllotmentRepository();
    ICourseRepository courseRepository = new CourseRepository();

    IRegistrationRepository registrationRepository = new RegistrationRepository();

    IAllotmentService allotmentService = new AllotmentService(allotmentRepository, courseRepository, registrationRepository);

    String courseId;
    String registrationId;
    @BeforeEach
    void setup(){

        List<String> tokens = new ArrayList<>();
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");

        Course course = courseRepository.save(new Course(tokens));
        courseId = course.getId();
        registrationId = registrationRepository.save(new Registration("abc@xyz.com", "abc", course)).getId();
    }

    @Test
    void allot() {
        List<String> actual = allotmentService.allot(courseId);
        assertEquals(actual.size(), 0);
    }

    @Test
    void cancel() {
        String expected = "REG-COURSE-abc-DATASCIENCECANCEL_ACCEPTED";
        String actual =  allotmentService.cancel(registrationId);
        assertEquals(expected, actual);
    }

    @Test
    void removeRegistration() {
        Course course = courseRepository.findById(courseId).get();
        Registration registration = registrationRepository.findById(registrationId).get();

        allotmentService.removeRegistration(registration, course);

        assertEquals(registrationRepository.findAll().size(), 0);
    }
}