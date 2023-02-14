package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long id;
    private String name;
    private String email;
    private String address;
    private String username;
    private String password;
    private List<Booking> bookingList;
    private User serviceWorker;
}
