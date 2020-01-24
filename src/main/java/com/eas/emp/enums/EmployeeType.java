package com.eas.emp.enums;

public enum EmployeeType {
  PERMANENT(1),
  TEMPORARY(2),
  CONTRACTUAL(3),
  SUBCONTRACT(4),
  PARTTIME(5),
  INTERNSHIP(6);

  private final int employeeType;

  EmployeeType(int employeeType) {
    this.employeeType = employeeType;
  }

  public int getEmployeeType() {
    return this.employeeType;
  }
}
