package com.eas.emp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "userinfo")
public class SignupModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @NotNull private String employeeId;
  @NotNull private Integer companyId;

  @NotNull private String passwords;
  @Transient private String confirmPasswords;
  @Transient private int userExist;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

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

  public int getUserExist() {
    return userExist;
  }

  public void setUserExist(int userExist) {
    this.userExist = userExist;
  }
}
