package com.example.cart_app.service.impl;

import com.example.cart_app.model.Product;
import com.example.cart_app.repository.IProductRepository;
import com.example.cart_app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(Math.toIntExact(id));
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }
}
