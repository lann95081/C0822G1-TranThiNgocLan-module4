package com.example.case_study.service.customer;

import com.example.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
