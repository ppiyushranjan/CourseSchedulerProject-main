package com.example.geektrust.services;

import java.util.Optional;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.Entities.Registration;
import com.example.geektrust.repositories.ICourseRepository;
import com.example.geektrust.repositories.IRegistrationRepository;

public class RegistrationService implements IRegistrationService {

    ICourseRepository iCourseRepository;
    IRegistrationRepository iRegistrationRepository;

    public RegistrationService(ICourseRepository iCourseRepository, IRegistrationRepository iRegistrationRepository) {
        this.iCourseRepository = iCourseRepository;
        this.iRegistrationRepository = iRegistrationRepository;
    }

    @Override
    public String register(String email, String courseId) {
        // TODO Auto-generated method stub
        String employeeName = email.split("@")[0];
        Optional<Course> course = iCourseRepository.findById(courseId);

        if(course.get().getRegistrations().size() == course.get().getMax()){
            return "COURSE_FULL_ERROR";
        }

        Registration registration = new Registration(email, employeeName, course.get());
        Registration saved = iRegistrationRepository.save(registration);
        course.get().getRegistrations().add(saved);
        return saved.getId() + " ACCEPTED";
    }
}
