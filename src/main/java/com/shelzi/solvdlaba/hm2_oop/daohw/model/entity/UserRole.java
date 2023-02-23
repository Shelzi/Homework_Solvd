package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import java.util.Optional;

public enum UserRole {
    ADMIN(1),
    HEAD_MANAGER(2),
    SALES_MANAGER(3);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<UserRole> valueOfRoleId(int id) {
        for (UserRole e : values()) {
            if (e.id == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}
