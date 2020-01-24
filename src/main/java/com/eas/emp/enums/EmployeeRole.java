package com.eas.emp.enums;

public enum  EmployeeRole {
    ADMIN(1),
    MANAGER(2),
    ENGINEER(3);

    private final int employeeRole;

    EmployeeRole(int employeeRole) {
        this.employeeRole = employeeRole;
    }

    public int getEmployeeRole() {
        return employeeRole;
    }
}
