package com.eas.emp.model;

public class LoginModel {
    private Integer companyId;
    private  String employeeId;
    private String passwords;

    public LoginModel() {
    }

    public LoginModel(Integer companyId, String employeeId, String passwords) {
        this.companyId = companyId;
        this.employeeId = employeeId;
        this.passwords = passwords;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
