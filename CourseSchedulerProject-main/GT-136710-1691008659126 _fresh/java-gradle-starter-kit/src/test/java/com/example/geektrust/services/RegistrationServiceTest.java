package com.example.geektrust.services;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.repositories.CourseRepository;
import com.example.geektrust.repositories.ICourseRepository;
import com.example.geektrust.repositories.IRegistrationRepository;
import com.example.geektrust.repositories.RegistrationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceTest {
    ICourseRepository courseRepository = new CourseRepository();
    IRegistrationRepository registrationRepository = new RegistrationRepository();

    IRegistrationService registrationService = new RegistrationService(courseRepository, registrationRepository);
    String courseId;
    String email = "abc@xyz.com";
    @BeforeEach
    void setup(){
        List<String> tokens = new ArrayList<>();
        Course course;
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");
        course = new Course(tokens);
        courseId = courseRepository.save(course).getId();
    }

    @Test
    void register() {
        String actual = registrationService.register(email, courseId);
        assertEquals(actual, "REG-COURSE-abc-DATASCIENCE ACCEPTED");
    }
}