package com.example.geektrust.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.geektrust.Entities.Allotment;

public class AllotmentRepository implements IAllotmentRepository {

    Integer autoInteger = 0;
    Map<String, Allotment> allotmentData;


    public AllotmentRepository() {
        allotmentData = new HashMap<>();
    }

    @Override
    public Allotment save(Allotment entity) {
        // TODO Auto-generated method stub
        if (entity.getId() == null) {

            autoInteger++;

            Allotment allotment = new Allotment(Integer.toString(autoInteger), entity.getCourse(), entity.getAllotmentStatus());
            allotmentData.put(allotment.getId(), allotment);
            return allotment;
        } 
        else {
            return allotmentData.get(entity.getId());
        }
    }

    @Override
    public List<Allotment> findAll() {
        // TODO Auto-generated method stub
        return allotmentData.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Allotment> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(allotmentData.get(id));
    }

}
