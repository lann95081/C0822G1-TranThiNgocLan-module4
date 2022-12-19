package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductManagementRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductManagementRepository implements IProductManagementRepository {
    private static final Map<Integer, Product> productList;

    static {
        productList = new HashMap<>();
        productList.put(1, new Product(1, "Trung ga", 12000, "no", "Thuy Diem company"));
        productList.put(2, new Product(2, "Dau tay", 30000, "no", "Quang NN company"));
        productList.put(3, new Product(3, "Hong", 15000, "no", "My home"));
        productList.put(4, new Product(4, "Tao", 20000, "no", "My home"));
        productList.put(5, new Product(5, "Keo mut", 1000, "no", "Thanh Nguyen company"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();

        for (Product item : productList.values()) {
            if (item.getName().contains(name)) {
                products.add(item);
            }
        }
        return products;
    }
}
