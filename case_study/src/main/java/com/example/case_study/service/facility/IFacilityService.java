package com.example.case_study.service.facility;

import com.example.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Optional<Facility> findById(Integer id);

    void update(Facility facility);

    void deleteLogical(Integer id);

    Page<Facility> searchFacility(String nameSearch, Pageable pageable);

    Page<Facility> searchFacilityType(String nameSearch, Integer facilityType, Pageable pageable);
}
