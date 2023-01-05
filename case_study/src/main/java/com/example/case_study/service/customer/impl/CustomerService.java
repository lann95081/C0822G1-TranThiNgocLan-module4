package com.example.case_study.service.customer.impl;

import com.example.case_study.dto.CustomerDto;
import com.example.case_study.model.customer.Customer;
import com.example.case_study.repository.customer.ICustomerRepository;
import com.example.case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

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
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch, emailSearch, pageable);
    }

    @Override
    public Page<Customer> searchCustomerType(String nameSearch, String emailSearch, Integer customerType, Pageable pageable) {
        return iCustomerRepository.searchCustomerType(nameSearch, emailSearch, customerType, pageable);
    }

    @Override
    public Map<String, String> messError(CustomerDto customerDto) {
        Map<String, String> messError=new HashMap<>();
        for (Customer customer:iCustomerRepository.findAll()) {
            if (customer.getCustomerIdCard().equals(customerDto.getCustomerIdCard())){
                messError.put("Id Card","Id Card đã tồn tại!!");
            }
            if (customer.getCustomerEmail().equals(customerDto.getCustomerEmail())){
                messError.put("Email","Email đã tồn tại!!");
            }
            if (customer.getCustomerPhone().equals(customerDto.getCustomerPhone())){
                messError.put("Số điện thoại","Số điện thoại đã tồn tại!!");
            }
        }
        return messError;
    }
}
