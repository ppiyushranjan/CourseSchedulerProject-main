package com.example.geektrust.repositories;

import com.example.geektrust.Entities.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    Course course;
    ICourseRepository courseRepository = new CourseRepository();

    @BeforeEach
    public void setup(){
        List<String> tokens = new ArrayList<>();
        tokens.add("ADD-COURSE-OFFERING");
        tokens.add("DATASCIENCE");
        tokens.add("808");
        tokens.add("05062022");
        tokens.add("3");
        tokens.add("5");
        course = new Course(tokens);
    }


    @Test
    void save() {
        Course actual = courseRepository.save(course);

        assertEquals(actual.getCourseName(), course.getCourseName());
        assertEquals(actual.getInstructor(), course.getInstructor());
    }

    @Test
    void findAll() {
        courseRepository.save(course);

        List<Course> actual = courseRepository.findAll();

        assertEquals(actual.size(), 1);
    }

    @Test
    void findById() {
        Course savedCourse = courseRepository.save(course);
        String id = savedCourse.getId();

        Optional<Course> actual = courseRepository.findById(id);

        assertEquals(actual.get().getInstructor(), course.getInstructor());
        assertEquals(actual.get().getCourseName(), course.getCourseName());
    }
}