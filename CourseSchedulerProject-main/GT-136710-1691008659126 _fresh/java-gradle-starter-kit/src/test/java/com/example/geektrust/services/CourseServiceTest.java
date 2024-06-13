package com.example.geektrust.services;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.repositories.CourseRepository;
import com.example.geektrust.repositories.ICourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    ICourseRepository courseRepository = new CourseRepository();
    ICourseService courseService = new CourseService(courseRepository);
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
        courseRepository.save(course);
    }


    @Test
    void addCourseOffering() {
        String actual = courseService.addCourseOffering(tokens);

        assertEquals(actual, "OFFERING-DATASCIENCE-808");

    }
}