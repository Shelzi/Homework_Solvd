package com.shelzi.solvdlaba.hm2_oop.daohw.model.entity;

import com.shelzi.solvdlaba.hm2_oop.daohw.parser.jaxb.adapter.LocalDateTimeAdapter;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {
    private long id;
    private int amount;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime time;
    private String description;
}
