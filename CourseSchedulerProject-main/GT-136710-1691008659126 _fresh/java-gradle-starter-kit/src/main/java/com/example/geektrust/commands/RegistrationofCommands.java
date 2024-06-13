package com.example.geektrust.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RegistrationofCommands {
    private static final Map<String, InterfaceCommand> commands = new HashMap<>();

    public void registerCommand(String commandKeyword, InterfaceCommand command) {
        commands.putIfAbsent(commandKeyword,command);
    }

    private InterfaceCommand get(String commandName){
        return commands.get(commandName);
    }

    private List<String> parse(String input){
        return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    }


    public void executeCommand(String input) {
        List<String> tokens = parse(input);
        InterfaceCommand command = get(tokens.get(0));
        if(command == null){
            // Handle Exception
            throw new RuntimeException("INPUT_DATA_ERROR");
        } 
        command.execute(tokens);
        return;
    }
}
