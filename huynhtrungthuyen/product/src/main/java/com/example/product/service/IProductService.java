package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Integer id);

    void update(Product product);

    void deleteLogical(Integer id);

    Page<Product> searchProduct(String nameSearch, Pageable pageable);
}
