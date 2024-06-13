package com.example.geektrust.Entities;

public class Dues extends BaseEntity {
    Member lender;
    Member borrower;
    int amount;
    
    
    public Dues(Member lender, Member borrower, int amount) {
        this.lender = lender;
        this.borrower = borrower;
        this.amount = amount;
    }


    public Member getLender() {
        return lender;
    }


    public Member getBorrower() {
        return borrower;
    }


    public int getAmount() {
        return amount;
    }

    
}
