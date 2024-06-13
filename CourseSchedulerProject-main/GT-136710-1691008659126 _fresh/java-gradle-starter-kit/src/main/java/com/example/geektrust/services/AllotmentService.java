package com.example.geektrust.services;

import com.example.geektrust.Entities.Allotment;
import com.example.geektrust.Entities.CancellationStatus;
import com.example.geektrust.Entities.Course;
import com.example.geektrust.Entities.Registration;
import com.example.geektrust.repositories.IAllotmentRepository;
import com.example.geektrust.repositories.ICourseRepository;
import com.example.geektrust.repositories.IRegistrationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllotmentService implements IAllotmentService {

    private final IAllotmentRepository allotmentRepository;
    private final ICourseRepository courseRepository;
    private final IRegistrationRepository registrationRepository;

    

    public AllotmentService(IAllotmentRepository allotmentRepository, ICourseRepository courseRepository,
            IRegistrationRepository registrationRepository) {
        this.allotmentRepository = allotmentRepository;
        this.courseRepository = courseRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public List<String> allot(String courseId) {
        // TODO Auto-generated method stub
        Course course = courseRepository.findById(courseId).get();
        Allotment allotment;
        if(course.getRegistrations().size()>=course.getMin()){
            allotment = new Allotment(course, "CONFIRMED");
        }
        else{
            allotment = new Allotment(course, "COURSE_CANCELED");
        }
        Allotment saved = allotmentRepository.save(allotment);
        List<Registration> registrationList = saved.getCourse().getRegistrations();
        List<String> allotmentList = new ArrayList<>();
        for(Registration registration : registrationList){
            allotmentList.add(registration.getId() + " " + registration.getEmail() + " " + 
                registration.getCourse().getId() + " " + registration.getCourse().getCourseName() + " " +
                registration.getCourse().getInstructor() + " " + registration.getCourse().getDate() + " " +
                saved.getAllotmentStatus()
            );
        }
        return allotmentList.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String cancel(String registrationId) {
        // TODO Auto-generated method stub
        Registration registration = registrationRepository.findById(registrationId).get();
        Course course = registration.getCourse();
        List<Allotment> allotments = allotmentRepository.findAll();
        for(Allotment allotment : allotments){
            if(allotment.getCourse().equals(course)){
                return registrationId + CancellationStatus.STATUS_CANCEL_REJECTED.getName();
            }
        }
        removeRegistration(registration, course);
        return registrationId + CancellationStatus.STATUS_CANCEL_ACCEPTED.getName();
    }

    @Override
    public void removeRegistration(Registration registration, Course course) {
        // TODO Auto-generated method stub
        course.getRegistrations().remove(registration);
        courseRepository.save(course);
        registrationRepository.delete(registration);
    }
    
}

