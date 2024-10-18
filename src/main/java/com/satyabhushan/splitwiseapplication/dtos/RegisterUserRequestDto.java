package com.satyabhushan.splitwiseapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String UserName ;
    private String phoneNumber ;
    private String password ;
}
