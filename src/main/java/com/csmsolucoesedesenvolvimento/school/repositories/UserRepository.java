package com.csmsolucoesedesenvolvimento.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csmsolucoesedesenvolvimento.school.management.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}