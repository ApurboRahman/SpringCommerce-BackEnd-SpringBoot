package com.eas.emp.controllers;

import com.eas.emp.model.SignupModel;
import com.eas.emp.services.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

  private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
  @Autowired private SignupService signupService;

  @PostMapping("/signup")
  @ResponseBody
  public SignupModel signup(@RequestBody SignupModel signupModel) {
    return signupService.save(signupModel);
  }

  @PostMapping("/changePasswords")
  @ResponseBody
  public void changePasswords(@RequestBody SignupModel signupModel) {
   signupService.changePasswords(signupModel);

  }
}
