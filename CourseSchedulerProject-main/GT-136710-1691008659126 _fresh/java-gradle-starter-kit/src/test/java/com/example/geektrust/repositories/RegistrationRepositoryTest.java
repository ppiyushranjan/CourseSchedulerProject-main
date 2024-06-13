package com.example.geektrust.repositories;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.Entities.Registration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationRepositoryTest {
    Registration registration ;
    IRegistrationRepository registrationRepository = new RegistrationRepository();

    @BeforeEach
    void setup(){
        List<String> tokens = new ArrayList<>();
        Course course;
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

        registration = new Registration(tokens.get(0), tokens.get(1), course);
    }

    @Test
    void save() {
        Registration actual = registrationRepository.save(registration);

        assertEquals(registration.getCourse(), actual.getCourse());
        assertEquals(registration.getEmail(), actual.getEmail());
        assertEquals(registration.getEmployeeName(), actual.getEmployeeName());
    }

    @Test
    void findAll() {
        registrationRepository.save(registration);

        List<Registration> actual = registrationRepository.findAll();

        assertEquals(actual.size(), 1);
    }

    @Test
    void findById() {
        Registration actual = registrationRepository.save(registration);
        String actualId = actual.getId();
        Optional<Registration> findByIdRegistration = registrationRepository.findById(actualId);
        assertEquals(findByIdRegistration.get().getEmployeeName(), actual.getEmployeeName());
        assertEquals(findByIdRegistration.get().getEmail(), actual.getEmail());
        assertEquals(findByIdRegistration.get().getCourse(), actual.getCourse());
    }

    @Test
    void delete() {
        Registration toBeDeleted = registrationRepository.save(registration);

        registrationRepository.delete(toBeDeleted);

        assertEquals(registrationRepository.findAll().size(), 0);

    }
}