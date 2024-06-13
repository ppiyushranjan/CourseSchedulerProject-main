package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IAllotmentService;

public class CancelCommand extends AbstractCommand {

    private static final int REGISTRATION_ID_TOKEN_INDEX = 1;
    private static final int VALID_TOKEN_SIZE = 2;

    public CancelCommand(IAllotmentService allotmentService) {
        super(allotmentService);
    }

    // CANCEL REG-COURSE-ANDY-JAVA
    // REG-COURSE-ANDY-JAVA CANCEL_REJECTED
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        if (tokens.size()!= VALID_TOKEN_SIZE){
            System.out.println("INPUT-DATA-ERROR");
            return;
        }

        System.out.println(allotmentService.cancel(tokens.get(REGISTRATION_ID_TOKEN_INDEX)));
    }
}
