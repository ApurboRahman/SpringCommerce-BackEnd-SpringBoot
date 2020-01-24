package com.eas.emp.dto;

import java.util.Date;

public class BasicInfoDto {
  private String employeeId;
  private String firstName;
  private String lastName;
  private Integer companyId;
  private String companyName;
  private String phoneNo;
  private char sexId;
  private String sexName;
  private Date birthDate;
  private Date joiningDate;
  private Integer department;
  private String departmentName;
  private boolean employeeExist;

  public BasicInfoDto(
      String employeeId,
      String firstName,
      String lastName,
      Integer companyId,
      String companyName,
      String phoneNo,
      char sexId,
      String sexName,
      Date birthDate,
      Date joiningDate,
      Integer department,
      String departmentName) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.companyId = companyId;
    this.companyName = companyName;
    this.phoneNo = phoneNo;
    this.sexId = sexId;
    this.sexName = sexName;
    this.birthDate = birthDate;
    this.joiningDate = joiningDate;
    this.department = department;
    this.departmentName = departmentName;
  }

  public BasicInfoDto() {}

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Integer companyId) {
    this.companyId = companyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public char getSexId() {
    return sexId;
  }

  public void setSexId(char sexId) {
    this.sexId = sexId;
  }

  public String getSexName() {
    return sexName;
  }

  public void setSexName(String sexName) {
    this.sexName = sexName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Integer getDepartment() {
    return department;
  }

  public void setDepartment(Integer department) {
    this.department = department;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

    public boolean isEmployeeExist() {
        return employeeExist;
    }

    public void setEmployeeExist(boolean employeeExist) {
        this.employeeExist = employeeExist;
    }
}
