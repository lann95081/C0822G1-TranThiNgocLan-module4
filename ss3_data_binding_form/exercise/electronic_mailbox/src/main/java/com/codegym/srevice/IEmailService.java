package com.codegym.srevice;

import com.codegym.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void update(Email email);

    Email findById(int id);

    List<String> findLanguage();

    List<Integer> findPageSize();
}
