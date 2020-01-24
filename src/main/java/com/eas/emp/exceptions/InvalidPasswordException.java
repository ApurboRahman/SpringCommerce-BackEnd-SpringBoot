package com.eas.emp.exceptions;


import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class InvalidPasswordException extends AbstractThrowableProblem {
    /*Following variables should be shifted to new constant file*/
    public static final String PROBLEM_BASE_URL = "http://localhost:8081";
    public static final URI INVALID_PASSWORD_TYPE = URI.create(PROBLEM_BASE_URL + "/invalid-password");

    private static final long serialVersionUID = 1L;

    public InvalidPasswordException() {
        super(INVALID_PASSWORD_TYPE, "Incorrect password", Status.BAD_REQUEST);
    }
}
