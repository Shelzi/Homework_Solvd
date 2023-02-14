package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import java.util.Optional;

public enum TransportType {
    TAXI(1),
    BUS(2),
    LIMOUSINE(3);
    private final int id;

    private TransportType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<TransportType> valueOfRoleId(int id) {
        for (TransportType e : values()) {
            if (e.id == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}