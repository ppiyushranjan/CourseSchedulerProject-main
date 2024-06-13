package com.example.geektrust.repositories;

import com.example.geektrust.Entities.Registration;

public interface IRegistrationRepository extends CRUDRepository<Registration, String> {
    public void delete(Registration entity);
}
