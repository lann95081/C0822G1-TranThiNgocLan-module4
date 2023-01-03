package com.example.case_study.service.contract.impl;

import com.example.case_study.model.contract.AttachFacility;
import com.example.case_study.repository.contract.IAttachFacilityRepository;
import com.example.case_study.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
