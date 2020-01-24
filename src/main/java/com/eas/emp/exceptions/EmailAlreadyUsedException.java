package com.eas.emp.exceptions;

public class EmailAlreadyUsedException extends RuntimeException{
    public EmailAlreadyUsedException() {
        super("Login name already used!");
    }
}
