package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IRegistrationService;

public class RegisterCommand implements ICommand {

    private final IRegistrationService registrationService;

    private static final int EMAIL_TOKEN_INDEX = 1;
    private static final int COURSE_ID_TOKEN_INDEX = 2;
    private static final int VALID_TOKEN_SIZE = 3;

    public RegisterCommand(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES
    // REG-COURSE-ANDY-JAVA ACCEPTED

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.size()!= VALID_TOKEN_SIZE){
            System.out.println("INPUT_DATA_ERROR");
            return;
        }

        String email = tokens.get(EMAIL_TOKEN_INDEX);
        String courseId = tokens.get(COURSE_ID_TOKEN_INDEX);
        
        System.out.println(registrationService.register(email, courseId));
    }
    
}
