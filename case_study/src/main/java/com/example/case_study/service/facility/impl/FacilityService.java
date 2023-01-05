package com.example.case_study.service.facility.impl;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.repository.facility.IFacilityRepository;
import com.example.case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        for (Facility fac : iFacilityRepository.findAll()) {
            if (fac.getFacilityName().equals(facility.getFacilityName())) {
                iFacilityRepository.findAll();
            } else {
                iFacilityRepository.save(facility);
            }
        }
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void deleteLogical(Integer id) {
        iFacilityRepository.deleteLogical(id);
    }

    @Override
    public Page<Facility> searchFacility(String nameSearch, Pageable pageable) {
        return iFacilityRepository.searchFacility(nameSearch, pageable);
    }

    @Override
    public Page<Facility> searchFacilityType(String nameSearch, Integer facilityType, Pageable pageable) {
        return iFacilityRepository.searchFacilityType(nameSearch, facilityType, pageable);
    }
}
