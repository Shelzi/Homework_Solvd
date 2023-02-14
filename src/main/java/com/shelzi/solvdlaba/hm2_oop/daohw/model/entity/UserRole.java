package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

public enum UserRole {
    ADMIN(1),
    HEAD_MANAGER(2),
    SALES_MANAGER(3);

    private final int id;

    private UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
