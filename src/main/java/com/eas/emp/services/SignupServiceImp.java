package com.eas.emp.services;

import com.eas.emp.repository.SignupRepository;
import com.eas.emp.model.SignupModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("signupService")
public class SignupServiceImp implements SignupService {

  private static final Logger logger = LoggerFactory.getLogger(SignupServiceImp.class);
  @Autowired private SignupRepository signupRepository;
  @Autowired private BasicInfoService basicInfoService;

  @Override
  public SignupModel save(SignupModel signupModel) {

    boolean notEmployee = basicInfoService.notEmployee(signupModel.getEmployeeId(), signupModel.getCompanyId());
    if (notEmployee) {
      signupModel.setUserExist(0);
      logger.info("User info didn't find. Please register first as an employee");
      return signupModel;
    }
    if (signupRepository.existByEmployeeIdAndCompanyId(
            signupModel.getEmployeeId(), signupModel.getCompanyId())
        == 1) {
      logger.info("Already user has been created with this info. Please check.");
      System.out.println("Already user has been created with this info. Please check.");
      signupModel.setUserExist(1);
      return signupModel;
    }
    boolean checkPss =
        checkPasswordsValidation(signupModel.getPasswords(), signupModel.getConfirmPasswords());
    if (!checkPss) {
      signupModel.setUserExist(2);
      return signupModel;
    }
    signupRepository.save(signupModel);
    signupModel.setUserExist(3);
    return signupModel;
  }

  @Override
  public boolean changePasswords(SignupModel signupModel) {

    if (!checkPasswordsValidation(signupModel.getPasswords(), signupModel.getConfirmPasswords())) {
      return false;
    }

    if (signupRepository.existByEmployeeIdAndCompanyId(
            signupModel.getEmployeeId(), signupModel.getCompanyId())
        != 1) {
      logger.info("User info didn't find.");
      return false;
    }
    SignupModel existingModel =
        signupRepository.findByEmployeeIdAndCompanyId(
            signupModel.getEmployeeId(), signupModel.getCompanyId());
    existingModel.setPasswords(signupModel.getPasswords());
    signupRepository.save(existingModel);
    logger.info("passwords changed success");
    return true;
  }

  private boolean checkPasswordsValidation(String passwords, String confirmPasswords) {
    Pattern pswNamePtrn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,8})");
    Matcher mtch = pswNamePtrn.matcher(passwords);
    if (!mtch.matches()) {
      logger.info(
          "passwords length must be 6-8 including at least 1 capital letter, 1 number and 1 special character.");
      System.out.println(
          "passwords length must be 6-8 including at least 1 capital letter, 1 number and 1 special character.");
      return false;
    }
    if (!passwords.equals(confirmPasswords)) {
      logger.info("passwords and confirm passwords do not match");
      System.out.println("passwords and confirm passwords do not match");
      return false;
    }
    return true;
  }
}