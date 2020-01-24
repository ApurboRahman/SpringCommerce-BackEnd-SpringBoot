package com.eas.emp.services;

import com.eas.emp.dto.LoginDto;
import com.eas.emp.dto.SignupDto;
import com.eas.emp.repository.SignupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
  private static final Logger logger = LoggerFactory.getLogger(LoginServiceImp.class);
  @Autowired
  SignupRepository signupRepository;

  @Override
  public LoginDto userLogin(LoginDto loginDto) {
    if (signupRepository.findByEmployeeIdAndCompanyIdAndPasswords(
            loginDto.getEmployeeId(), loginDto.getCompanyId(), loginDto.getPasswords())
        == 1) {
      loginDto.setUserExist(1);
      logger.info("{} login completed successfully", loginDto.getEmployeeId());
    }
    return loginDto;
  }

  @Override
  public SignupDto getUserInfo(SignupDto signupDto) {
    Integer userInfo =
        signupRepository.findByEmployeeIdAndCompanyIdAndPasswords(
            signupDto.getEmployeeId(), signupDto.getCompanyId(), signupDto.getPasswords());
    signupDto.setUserExist(userInfo);
    return signupDto;
  }
}
