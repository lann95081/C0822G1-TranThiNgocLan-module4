package com.example.case_study.service.contract.impl;

import com.example.case_study.dto.IContractDto;
import com.example.case_study.model.contract.Contract;
import com.example.case_study.repository.contract.IContractRepository;
import com.example.case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<IContractDto> findAllDto() {
        return iContractRepository.findAllDto();
    }

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return iContractRepository.findAllDto(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
