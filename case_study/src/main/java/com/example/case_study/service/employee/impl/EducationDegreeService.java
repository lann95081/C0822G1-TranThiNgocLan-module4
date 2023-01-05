package com.example.case_study.service.employee.impl;

import com.example.case_study.model.employee.EducationDegree;
import com.example.case_study.repository.employee.IEducationDegreeRepository;
import com.example.case_study.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
