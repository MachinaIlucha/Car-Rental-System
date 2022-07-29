package com.illiapinchuk.carrentalsystem.model;

public enum RoleName {
    CUSTOMER,
    ADMIN;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
