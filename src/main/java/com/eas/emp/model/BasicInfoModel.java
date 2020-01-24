package com.eas.emp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employeebasicinfo")
public class BasicInfoModel {
  @Id private String employeeId;
  @NotBlank private String firstName;
  @NotBlank private String lastName;
  @NotNull private Integer companyId;
  @Transient private String companyName;
  private String phoneNo;

  @Column(name = "sex")
  private char sex;

  @Transient private String sexName;

  @Temporal(TemporalType.TIMESTAMP)
  private Date birthDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date joiningDate;

  @NotNull private Integer department;
  @Transient private String departmentName;

  @ManyToOne
  @JoinColumn(name = "sex", referencedColumnName = "id", insertable = false, updatable = false)
  private GenderModel genderModel;

  @ManyToOne
  @JoinColumn(
      name = "department",
      referencedColumnName = "id",
      insertable = false,
      updatable = false)
  private DepartmentModel departmentModel;

  @ManyToOne
  @JoinColumn(
      name = "companyId",
      referencedColumnName = "id",
      insertable = false,
      updatable = false)
  private CompanyModel companyModel;

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

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
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

  public GenderModel getGenderModel() {
    return genderModel;
  }

  public void setGenderModel(GenderModel genderModel) {
    this.genderModel = genderModel;
  }

  public DepartmentModel getDepartmentModel() {
    return departmentModel;
  }

  public void setDepartmentModel(DepartmentModel departmentModel) {
    this.departmentModel = departmentModel;
  }

  public CompanyModel getCompanyModel() {
    return companyModel;
  }

  public void setCompanyModel(CompanyModel companyModel) {
    this.companyModel = companyModel;
  }
}
