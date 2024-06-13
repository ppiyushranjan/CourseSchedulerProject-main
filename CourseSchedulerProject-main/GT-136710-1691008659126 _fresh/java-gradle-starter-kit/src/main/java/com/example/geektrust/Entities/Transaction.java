package com.example.geektrust.Entities;

import java.util.List;

public class Transaction {
    Member lender;
    List<Member> listOfBorrowers;
    int amount;


    public Transaction(Member lender, List<Member> listOfBorrowers, int amount) {
        this.lender = lender;
        this.listOfBorrowers = listOfBorrowers;
        this.amount = amount;
    }

    public Member getLender() {
        return lender;
    }

    public List<Member> getListOfBorrowers() {
        return listOfBorrowers;
    }
    
    public int getAmount() {
        return amount;
    }

    
}
