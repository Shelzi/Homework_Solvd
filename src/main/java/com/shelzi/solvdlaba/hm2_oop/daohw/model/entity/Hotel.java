package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private long id;
    private int rating;
    private String address;
    private String name;
    private String description;
}
