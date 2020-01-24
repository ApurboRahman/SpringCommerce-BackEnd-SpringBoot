package com.eas.emp.dto;

public class LoginDto {
  private String employeeId;
  private Integer companyId;
  private String passwords;
  private Integer userExist;

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

  public Integer getUserExist() {
    return userExist;
  }

  public void setUserExist(Integer userExist) {
    this.userExist = userExist;
  }
}
