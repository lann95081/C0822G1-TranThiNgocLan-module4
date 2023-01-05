package com.example.case_study.repository.employee;

import com.example.case_study.model.employee.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Divisions, Integer> {
}
