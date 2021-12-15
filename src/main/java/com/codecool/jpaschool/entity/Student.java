package com.codecool.jpaschool.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column(nullable = false, unique = true)
    private String email;
    private LocalDate birthdate;

    @Transient
    private long age;

    @OneToOne(cascade = CascadeType.PERSIST) // ONE-TO-ONE : Both Class should have the OneToOne above their pointing fields
    private Address address;

    @ElementCollection //kapcsolótábla
    @Singular
    private List<String> phoneNumbers;

}


