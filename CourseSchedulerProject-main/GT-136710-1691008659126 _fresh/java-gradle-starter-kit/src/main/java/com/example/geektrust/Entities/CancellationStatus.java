package com.example.geektrust.Entities;

public enum CancellationStatus {
    STATUS_CANCEL_REJECTED("CANCEL_REJECTED"),
    STATUS_CANCEL_ACCEPTED("CANCEL_ACCEPTED");

    private final String name;

    private CancellationStatus(String nameString) {
        this.name = nameString;
    }

    public String getName() {
        return name;
    }    
}
