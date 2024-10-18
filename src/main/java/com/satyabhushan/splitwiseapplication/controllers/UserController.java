package com.satyabhushan.splitwiseapplication.controllers;

import com.satyabhushan.splitwiseapplication.dtos.RegisterUserRequestDto;
import com.satyabhushan.splitwiseapplication.dtos.RegisterUserResponseDto;
import com.satyabhushan.splitwiseapplication.exceptions.UserAlreadyExist;
import com.satyabhushan.splitwiseapplication.models.User;
import com.satyabhushan.splitwiseapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService ;

    public UserController(UserService userService){
        this.userService = userService;
    }
//
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto) {
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        try{
            User user = userService.registerUser(requestDto.getUserName(),
                    requestDto.getPhoneNumber(),
                    requestDto.getPassword());
            responseDto.setUserId(user.getId());
            responseDto.setStatus("SUCCESS");
            responseDto.setMessage("User Registered Successfully");
            return responseDto;
        } catch (UserAlreadyExist e) {
            responseDto.setStatus("FAILURE");
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }
}
