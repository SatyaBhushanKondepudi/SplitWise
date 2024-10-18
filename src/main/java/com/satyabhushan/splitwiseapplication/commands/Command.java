package com.satyabhushan.splitwiseapplication.commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
