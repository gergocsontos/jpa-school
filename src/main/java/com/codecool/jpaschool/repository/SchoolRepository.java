package com.codecool.jpaschool.repository;

import com.codecool.jpaschool.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
