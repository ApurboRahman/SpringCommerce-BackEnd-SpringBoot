package com.eas.emp.dto;

public class SignupDto {
  private String employeeId;
  private Integer companyId;
  private String passwords;
  private Integer userExist;

  private String confirmPasswords;

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getPasswords() {
    return passwords;
  }

  public void setPasswords(String passwords) {
    this.passwords = passwords;
  }

  public String getConfirmPasswords() {
    return confirmPasswords;
  }

  public void setConfirmPasswords(String confirmPasswords) {
    this.confirmPasswords = confirmPasswords;
  }

  public Integer getUserExist() {
    return userExist;
  }

  public void setUserExist(Integer userExist) {
    this.userExist = userExist;
  }
}
