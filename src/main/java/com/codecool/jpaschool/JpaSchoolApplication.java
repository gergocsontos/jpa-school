package com.codecool.jpaschool;

import com.codecool.jpaschool.entity.Address;
import com.codecool.jpaschool.entity.Location;
import com.codecool.jpaschool.entity.School;
import com.codecool.jpaschool.entity.Student;
import com.codecool.jpaschool.repository.AddressRepository;
import com.codecool.jpaschool.repository.SchoolRepository;
import com.codecool.jpaschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaSchoolApplication {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SchoolRepository schoolRepository;

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

            Student student2 = Student.builder()
                    .email("email2@email.com")
                    .name("Me2")
                    .birthdate(LocalDate.now())
                    .address(Address.builder()
                            .country("Hungary")
                            .city("Bpest")
                            .address("street 33")
                            .zipCode(1000)
                            .build())
                    .phoneNumber("333333")
                    .phoneNumber("2222")
                    .phoneNumber("11!!")
                    .build();

            List<Student> students = new ArrayList<>();
            students.add(student2);
            students.add(student);

            School school = School.builder()
                    .name("Codecool")
                    .location(Location.BUDAPEST)
                    .students(students)
                    .build();


            // IMPORTANT!!
            student.setSchool(school);
            student2.setSchool(school);

            schoolRepository.save(school);
        };
    }

}
