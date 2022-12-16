package com.codegym.srevice.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import com.codegym.srevice.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<Email> findAll() {
        return iEmailRepository.findAll();
    }

    @Override
    public void update(Email email) {
        iEmailRepository.update(email);
    }

    @Override
    public Email findById(int id) {
        return iEmailRepository.findById(id);
    }

    @Override
    public List<String> findLanguage() {
        return iEmailRepository.findLanguage();
    }

    @Override
    public List<Integer> findPageSize() {
        return iEmailRepository.findPageSize();
    }
}
