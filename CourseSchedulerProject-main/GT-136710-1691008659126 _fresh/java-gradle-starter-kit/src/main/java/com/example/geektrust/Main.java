package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.example.geektrust.commands.CommandRegistry;

public class Main {
    public static void main(String[] args)  {
        
        //Sample code to read from file passed as command line argument
        AppConfig appConfig = AppConfig.getInstance();

        CommandRegistry commandRegistry = appConfig.getCommandRegistry();

        //Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            // FileInputStream fis = new FileInputStream("sample_input/input1.txt"); //args[0]
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String line = sc.nextLine();
                commandRegistry.executeCommand(line);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}
}
