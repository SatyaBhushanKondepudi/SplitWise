package com.satyabhushan.splitwiseapplication.commands;

import org.springframework.stereotype.Component;

@Component
public class AddMemberCommand  implements Command {
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
