package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Transportation {
    private long id;
    private String description = "";
    private TransportType type;
}
