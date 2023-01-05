package com.example.case_study.service.customer;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findById(Integer id);

    void update(Customer customer);

    void deleteLogical(Integer id);

    Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable);

    Page<Customer> searchCustomerType(String nameSearch, String emailSearch, Integer customerType, Pageable pageable);

    Map<String,String> messError(CustomerDto customerDto);
}
