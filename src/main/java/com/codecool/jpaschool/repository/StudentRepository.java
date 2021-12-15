package com.codecool.jpaschool.repository;

import com.codecool.jpaschool.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
