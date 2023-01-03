package com.example.case_study.service.contract.impl;

import com.example.case_study.dto.IContractDetailDto;
import com.example.case_study.model.contract.ContractDetail;
import com.example.case_study.repository.contract.IContractDetailRepository;
import com.example.case_study.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<IContractDetailDto> showAll(Integer id) {
        return iContractDetailRepository.showAll(id);
    }
}
