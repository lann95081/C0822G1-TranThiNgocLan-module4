package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductManagementRepository;
import com.codegym.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagementService implements IProductManagementService {
    @Autowired
    private IProductManagementRepository iProductManagementRepository;

    @Override
    public List<Product> findAll() {
        return iProductManagementRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductManagementRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductManagementRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductManagementRepository.update(product);
    }

    @Override
    public void remove(int id) {
        iProductManagementRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductManagementRepository.findByName(name);
    }
}
