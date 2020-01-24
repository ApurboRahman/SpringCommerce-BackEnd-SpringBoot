package com.eas.emp.enums;

public enum Company {
    BJIT(1);

    private final int companyId;

    Company(int companyId) {
        this.companyId = companyId;
    }

    public int getCompanyId() {
        return companyId;
    }
}
