package com.example.geektrust.commands;

public enum KeywordOfCommand {
    // Register Command Keywords
    CREATE_GREETING_COMMAND("CREATE_GREETING"),
    LIST_GREETING_COMMAND ("LIST_GREETING"),
    GET_GREETING_COMMAND ("GET_GREETING"),
    MOVE_IN_COMMAND ("MOVE_IN"),
    ADD_COURSE_OFFERING_COMMAND ("ADD-COURSE-OFFERING"),
    REGISTER_COMMAND ("REGISTER"),
    ALLOT_COMMAND ("ALLOT"),
    CANCEL_COMMAND ("CANCEL");
    
    private final String name;
    private KeywordOfCommand(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     }
}
