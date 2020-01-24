package com.eas.emp.vm;

import com.eas.emp.dto.UserDTO;

import javax.validation.constraints.Size;

/**
 * view model extending the UserDTO, which is meant to be used in the user related(management) UI.
 */
public class ManagedUserVM extends UserDTO {
    public static final int PASSWORD_MIN_LENGTH = 4;
    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String confirmPass;

    public ManagedUserVM() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
                "password='" + password + '\'' +
                ", confirmPass='" + confirmPass + '\'' +
                '}';
    }
}
