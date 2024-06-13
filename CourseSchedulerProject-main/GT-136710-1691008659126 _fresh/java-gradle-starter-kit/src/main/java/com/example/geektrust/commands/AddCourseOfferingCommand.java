package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.ICourseService;

public class AddCourseOfferingCommand implements ICommand {

    private final ICourseService courseService;

    private static final int VALID_TOKEN_SIZE = 6;

    public AddCourseOfferingCommand(ICourseService courseService) {
        this.courseService = courseService;
    }

    // ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2 
    // OFFERING-JAVA-JAMES

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.size()!=VALID_TOKEN_SIZE){
            System.out.println("INPUT_DATA_ERROR");
            return;
        }

        System.out.println(courseService.addCourseOffering(tokens));
    }
    
}
