package com.example.geektrust.Entities;

import java.util.ArrayList;
import java.util.List;

public class Member extends BaseEntity {
    String name;
    List<Dues> listOfDues;
    List<Dues> listOfLents;
    
    
    public Member(String name) {
        this.name = name;
        this.listOfDues = new ArrayList<>();
        this.listOfLents = new ArrayList<>();
    }


    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public List<Dues> getListOfDues() {
        return listOfDues;
    }


    public List<Dues> getListOfLents() {
        return listOfLents;
    }

    
}
