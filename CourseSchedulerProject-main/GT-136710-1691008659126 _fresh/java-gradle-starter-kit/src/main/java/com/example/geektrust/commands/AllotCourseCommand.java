package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.IAllotmentService;

public class AllotCourseCommand extends AbstractCommand {

    private static final int COURSE_ID_TOKEN_INDEX = 1;

    public AllotCourseCommand(IAllotmentService allotmentService) {
        super(allotmentService);
    }

    // ALLOT OFFERING-JAVA-JAMES
    // REG-COURSE-ANDY-JAVA ANDY@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED 
    // REG-COURSE-WOO-JAVA WOO@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        List<String> allotments = allotmentService.allot(tokens.get(COURSE_ID_TOKEN_INDEX));
        for(String allotment : allotments){
            System.out.println(allotment);
        }
    }
    
}
