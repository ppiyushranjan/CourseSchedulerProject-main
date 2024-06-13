package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuesTest {

    Member lender, borrower;
    int amount = 10000;
    Dues dues;

    @BeforeEach
    void setUp(){
        lender = new Member("Satyam");
        borrower = new Member("abcd");
        dues = new Dues(lender, borrower, amount);
    }

    @Test
    void getLender() {
        Member actual = dues.getLender();

        assertEquals(actual, lender);
    }

    @Test
    void getBorrower() {
        Member actual = dues.getBorrower();

        assertEquals(actual, borrower);
    }

    @Test
    void getAmount() {
        int actual = dues.getAmount();

        assertEquals(actual, amount);
    }
}