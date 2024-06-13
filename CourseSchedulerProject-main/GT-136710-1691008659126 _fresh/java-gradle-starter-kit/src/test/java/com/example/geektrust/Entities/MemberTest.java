package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member;

    @BeforeEach
    void setup(){
        member = new Member("Satyam");
    }

    @Test
    void getName() {
        assertEquals("Satyam", member.getName());
    }

    @Test
    void getListOfDues() {
        assertEquals(0, member.getListOfDues().size());
    }

    @Test
    void getListOfLents() {
        assertEquals(0, member.getListOfLents().size());
    }
}