package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private long id;
    private int amount;
    private LocalDateTime time;
    private String description;
}
