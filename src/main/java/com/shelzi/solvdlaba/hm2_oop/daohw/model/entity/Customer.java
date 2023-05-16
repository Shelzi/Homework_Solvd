package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private long id;
    private String name;
    private String email;
    private String address;
    private String username;
    private String password;
    private User serviceWorker;
}
