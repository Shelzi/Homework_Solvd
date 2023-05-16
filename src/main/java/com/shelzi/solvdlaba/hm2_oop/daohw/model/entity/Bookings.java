package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bookings {

    @XmlElement(name = "booking")
    private List<Booking> bookingList;
}
