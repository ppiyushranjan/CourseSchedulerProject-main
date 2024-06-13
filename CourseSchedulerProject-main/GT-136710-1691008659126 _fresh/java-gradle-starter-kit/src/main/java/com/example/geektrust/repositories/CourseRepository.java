package com.example.geektrust.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.geektrust.Entities.Course;

public class CourseRepository implements ICourseRepository {

    String idGenerator = "OFFERING-";
    Map<String, Course> courseData;

    public CourseRepository() {
        this.courseData = new HashMap<>();
    }

    @Override
    public Course save(Course entity) {
        // TODO Auto-generated method stub
        if (entity.getId() == null) {

            String newId = idGenerator + entity.getCourseName() + "-" + entity.getInstructor();
            
            List<String> tokens = new ArrayList<String>() {{
                add(entity.getId());
                add(entity.getCourseName());
                add(entity.getInstructor());
                add(entity.getDate());
                add(Integer.toString(entity.getMin()));
                add(Integer.toString(entity.getMax()));
            } };

            Course course = new Course(newId, tokens);
            courseData.put(course.getId(), course);
            return course;
        } 
        else {
            return courseData.get(entity.getId());
        }
    }

    @Override
    public List<Course> findAll() {
        // TODO Auto-generated method stub
        return courseData.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Course> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(courseData.get(id));
    }
    
}
