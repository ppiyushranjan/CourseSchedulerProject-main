package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.repositories.ICourseRepository;

public class CourseService implements ICourseService {

    ICourseRepository iCourseRepository;
    

    public CourseService(ICourseRepository iCourseRepository) {
        this.iCourseRepository = iCourseRepository;
    }


    @Override
    public String addCourseOffering(List<String> parameters) {
        // TODO Auto-generated method stub
        Course course = new Course(parameters);
        return iCourseRepository.save(course).getId();
    }
    
}
