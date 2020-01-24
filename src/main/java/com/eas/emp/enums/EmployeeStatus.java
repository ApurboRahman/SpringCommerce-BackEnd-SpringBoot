package com.eas.emp.enums;

public enum EmployeeStatus {
    WORKING(1),
    RETIRED(2);

    public int getEmployeeStatus() {
        return EmployeeStatus;
    }

    private final int EmployeeStatus;

    EmployeeStatus(int employeeStatus) {
        EmployeeStatus = employeeStatus;
    }
}
