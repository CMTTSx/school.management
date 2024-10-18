package com.csmsolucoesedesenvolvimento.school.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csmsolucoesedesenvolvimento.school.management.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}