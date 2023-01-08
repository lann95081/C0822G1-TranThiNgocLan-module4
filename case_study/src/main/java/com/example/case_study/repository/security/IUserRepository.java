package com.example.case_study.repository.security;

import com.example.case_study.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);
}
