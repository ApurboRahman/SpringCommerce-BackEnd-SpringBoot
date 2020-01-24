package com.eas.emp.services;

import com.eas.emp.dto.LoginDto;
import com.eas.emp.dto.SignupDto;

public interface LoginService {

    LoginDto userLogin(LoginDto loginDto);

    SignupDto getUserInfo(SignupDto signupDto);
}
