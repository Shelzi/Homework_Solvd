package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {
    private long id;

    private String description;

    private String title;

    private Customer customer;

    private Hotel hotel;

    private Transportation transportation;

    private Payment payment;
}
