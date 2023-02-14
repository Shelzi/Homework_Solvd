package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private long id;
    private String description;
    private String title;

    private Hotel hotel;
    private Transportation transportation;
    private Payment payment;
}
