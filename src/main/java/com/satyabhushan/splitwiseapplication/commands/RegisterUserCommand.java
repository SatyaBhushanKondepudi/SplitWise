package com.satyabhushan.splitwiseapplication.commands;

import com.satyabhushan.splitwiseapplication.controllers.UserController;
import com.satyabhushan.splitwiseapplication.dtos.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
public class RegisterUserCommand implements Command {
    /*
    Register vinsmokesanji 003 namisswwaann
    u1 is registering with the username "vinsmokesanji", phone "003" and password as "namisswwaann"
     */
    private UserController userController ;

    public RegisterUserCommand(UserController userController){
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        if(inputWords.size() == 4 || inputWords.get(0).equalsIgnoreCase(CommandKeyWords.Register)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        System.out.println("Registring User ....");
        List<String> inputWords = Arrays.stream(input.split(" ")).toList();
        String username = inputWords.get(1);
        String phone = inputWords.get(2);
        String password = inputWords.get(3);

        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setUserName(username);
        request.setPhoneNumber(phone);
        request.setPassword(password);

        userController.registerUser(request);
        //Call User controller and register the user
    }
}
