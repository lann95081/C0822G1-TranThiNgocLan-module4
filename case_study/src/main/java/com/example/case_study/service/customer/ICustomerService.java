package com.example.case_study.service.customer;

import com.example.case_study.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);
}
