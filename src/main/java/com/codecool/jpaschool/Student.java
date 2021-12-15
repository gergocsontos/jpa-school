package com.codecool.jpaschool;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private LocalDate birthdate;
    private long age;

}
