package com.example.geektrust.services;

import java.util.List;

import com.example.geektrust.Entities.Course;
import com.example.geektrust.Entities.Registration;

public interface IAllotmentService {
    public List<String> allot(String courseId);
    public String cancel(String registrationId);
    public void removeRegistration(Registration registration, Course course);
}
