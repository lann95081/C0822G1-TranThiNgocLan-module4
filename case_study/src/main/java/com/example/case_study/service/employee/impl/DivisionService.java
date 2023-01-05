package com.example.case_study.service.employee.impl;

import com.example.case_study.model.employee.Divisions;
import com.example.case_study.repository.employee.IDivisionRepository;
import com.example.case_study.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Divisions> findAll() {
        return iDivisionRepository.findAll();
    }
}
