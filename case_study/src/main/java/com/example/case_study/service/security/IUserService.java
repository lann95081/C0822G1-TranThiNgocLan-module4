package com.example.case_study.service.security;

import com.example.case_study.model.security.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Integer id);
}
