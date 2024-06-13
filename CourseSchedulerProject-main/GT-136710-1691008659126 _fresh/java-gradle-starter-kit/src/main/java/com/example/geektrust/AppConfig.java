package com.example.geektrust;

import com.example.geektrust.commands.AddCourseOfferingCommand;
import com.example.geektrust.commands.AllotCourseCommand;
import com.example.geektrust.commands.CancelCommand;
import com.example.geektrust.commands.CommandKeyword;
import com.example.geektrust.commands.CommandRegistry;
import com.example.geektrust.commands.RegisterCommand;
import com.example.geektrust.repositories.IAllotmentRepository;
import com.example.geektrust.repositories.AllotmentRepository;
import com.example.geektrust.repositories.CourseRepository;
import com.example.geektrust.repositories.ICourseRepository;
import com.example.geektrust.repositories.IRegistrationRepository;
import com.example.geektrust.repositories.RegistrationRepository;
import com.example.geektrust.services.AllotmentService;
import com.example.geektrust.services.CourseService;
import com.example.geektrust.services.IAllotmentService;
import com.example.geektrust.services.ICourseService;
import com.example.geektrust.services.IRegistrationService;
import com.example.geektrust.services.RegistrationService;

public class AppConfig {
    // Singleton Pattern
    //create an object of Single Configuration Object
    private static AppConfig instance = new AppConfig();

    //make the constructor private so that this class cannot be
    //instantiated
    private AppConfig(){}

    //Get the only object available
    public static AppConfig getInstance(){
        return instance;
    }

    // Initialize repositories
    private final ICourseRepository iCourseRepository = new CourseRepository();
    private final IRegistrationRepository iRegistrationRepository = new RegistrationRepository();
    private final IAllotmentRepository iAllotmentRepository = new AllotmentRepository();

    // Initialize services
    private final ICourseService iCourseService = new CourseService(iCourseRepository);
    private final IRegistrationService iRegistrationService = new RegistrationService(iCourseRepository, iRegistrationRepository);
    private final IAllotmentService iAllotmentService = new AllotmentService(iAllotmentRepository, iCourseRepository, iRegistrationRepository);

    // Initialize commands
    private final AddCourseOfferingCommand addCourseOfferingCommand = new AddCourseOfferingCommand(iCourseService);
    private final RegisterCommand registerCommand = new RegisterCommand(iRegistrationService);
    private final AllotCourseCommand allotCourseCommand = new AllotCourseCommand(iAllotmentService);
    private final CancelCommand cancelCommand = new CancelCommand(iAllotmentService);
    
    // Initialize commandRegistery
    private final CommandRegistry commandRegistry = new CommandRegistry();

    // Register commands 
    private void registerCommands(){
        commandRegistry.registerCommand(CommandKeyword.ADD_COURSE_OFFERING_COMMAND.getName(), addCourseOfferingCommand);
        commandRegistry.registerCommand(CommandKeyword.REGISTER_COMMAND.getName(), registerCommand);
        commandRegistry.registerCommand(CommandKeyword.ALLOT_COMMAND.getName(), allotCourseCommand);
        commandRegistry.registerCommand(CommandKeyword.CANCEL_COMMAND.getName(), cancelCommand);
    }
    
    public CommandRegistry getCommandRegistry(){
        registerCommands();
        return commandRegistry;
    }
}
