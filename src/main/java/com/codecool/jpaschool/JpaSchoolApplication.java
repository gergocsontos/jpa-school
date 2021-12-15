package com.codecool.jpaschool;

import com.codecool.jpaschool.entity.Address;
import com.codecool.jpaschool.entity.Student;
import com.codecool.jpaschool.repository.AddressRepository;
import com.codecool.jpaschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JpaSchoolApplication {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaSchoolApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {


            Student student = Student.builder()
                    .email("email@email.com")
                    .name("Me")
                    .birthdate(LocalDate.now())
                    .address(Address.builder()
                                .country("Hungary")
                                .city("Bp")
                                .address("street 3")
                                .zipCode(1000)
                                .build())
                    .phoneNumber("55555")
                    .phoneNumber("5555d")
                    .phoneNumber("5555!!")
                    .build();

            studentRepository.save(student);
        };
    }

}
