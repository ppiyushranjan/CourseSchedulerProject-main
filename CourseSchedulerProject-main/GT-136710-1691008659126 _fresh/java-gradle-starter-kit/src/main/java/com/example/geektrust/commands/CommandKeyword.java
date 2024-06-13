package com.example.geektrust.commands;

public enum CommandKeyword {
    // Register Command Keywords
    ADD_COURSE_OFFERING_COMMAND ("ADD-COURSE-OFFERING"),
    REGISTER_COMMAND ("REGISTER"),
    ALLOT_COMMAND ("ALLOT"),
    CANCEL_COMMAND ("CANCEL");
    
    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     }
}
