package com.example.demo.service.impl;

import com.example.demo.dto.ICustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void deleteLogical(Integer id) {
        iCustomerRepository.deleteLogical(id);
    }

    @Override
    public Page<ICustomerDto> searchCustomer(String nameSearch, String emailSearch, String typeSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch,emailSearch,typeSearch,pageable);
    }

//    @Override
//    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable) {
//        return iCustomerRepository.searchCustomer(nameSearch, emailSearch, pageable);
//    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
