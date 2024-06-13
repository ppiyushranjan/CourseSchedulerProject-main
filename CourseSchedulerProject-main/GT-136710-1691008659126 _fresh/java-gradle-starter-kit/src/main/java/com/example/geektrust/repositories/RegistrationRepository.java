package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.geektrust.Entities.Registration;

public class RegistrationRepository implements IRegistrationRepository {

    String idGenerator = "REG-COURSE-";
    Map<String, Registration> registrationData;

    public RegistrationRepository() {
        registrationData = new HashMap<>();
    }

    @Override
    public Registration save(Registration entity) {
        // TODO Auto-generated method stub
        if (entity.getId() == null) {

            String newId = idGenerator + entity.getEmployeeName() + "-" + entity.getCourse().getCourseName();

            Registration registration = new Registration(newId, entity.getEmail(), entity.getEmployeeName(), entity.getCourse());
            registrationData.put(registration.getId(), registration);
            return registration;
        } 
        else {
            return registrationData.get(entity.getId());
        }
    }

    @Override
    public List<Registration> findAll() {
        // TODO Auto-generated method stub
        return registrationData.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Registration> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(registrationData.get(id));
    }

    @Override
    public void delete(Registration entity) {
        // TODO Auto-generated method stub
        registrationData.remove(entity.getId(), entity);
    }

}
