package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Member lender;
    List<Member> borrowers = new ArrayList<>();
    Transaction transaction;

    @BeforeEach
    void setup(){
        lender = new Member("Satyam");
        String name = "";
        for(int i=0; i<5; i++){
            borrowers.add(new Member(name+ new Random().nextInt( 40)));
        }
        transaction = new Transaction(lender, borrowers, 4000);
    }


    @Test
    void getLender() {
        Member actual = transaction.getLender();

        assertEquals(lender, actual);
    }

    @Test
    void getListOfBorrowers() {
        List<Member> actual = transaction.getListOfBorrowers();

        assertEquals(borrowers, actual);
    }

    @Test
    void getAmount() {
        int actual = transaction.getAmount();

        assertEquals(actual, transaction.getAmount());
    }
}