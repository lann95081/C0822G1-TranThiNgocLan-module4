package com.example.demo.service;

import com.example.demo.dto.ICustomerDto;
import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void save(Customer customer);

    Optional<Customer> findById(Integer id);

    void update(Customer customer);

    void deleteLogical(Integer id);

//    Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable);
    Page<ICustomerDto> searchCustomer(String nameSearch, String emailSearch, String typeSearch, Pageable pageable);

    List<Customer> findAll();
}
