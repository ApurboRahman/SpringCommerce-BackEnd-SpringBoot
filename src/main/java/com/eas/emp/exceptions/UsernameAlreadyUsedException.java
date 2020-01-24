package com.eas.emp.exceptions;

public class UsernameAlreadyUsedException extends RuntimeException{
    public UsernameAlreadyUsedException() {
        super("Login name already used!");
    }
}
