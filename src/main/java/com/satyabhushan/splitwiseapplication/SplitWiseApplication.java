package com.satyabhushan.splitwiseapplication;

import com.satyabhushan.splitwiseapplication.commands.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {

    private Scanner scanner ;
    private CommandRegistry commandRegistry ;

    public SplitWiseApplication(CommandRegistry commandRegistry){
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }
}
