package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String email;
    private String name;
    private String password;
    private boolean isBanned;
    private UserRole role;
}
