package com.eas.emp.enums;

public enum Department {
  ADMIN(1),
  HR(2),
  SALES(3),
  WEBENGINEERING(4),
  ANDROID(5);
  private final int departmentId;

  Department(int departmentId) {
    this.departmentId = departmentId;
  }

  public int getDepartmentId() {
    return departmentId;
  }
}
