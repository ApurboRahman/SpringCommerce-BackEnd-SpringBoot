package com.eas.emp.services;

import com.eas.emp.model.SignupModel;

public interface SignupService {
  SignupModel save(SignupModel signupModel);

  boolean changePasswords(SignupModel SignupModel);
}
