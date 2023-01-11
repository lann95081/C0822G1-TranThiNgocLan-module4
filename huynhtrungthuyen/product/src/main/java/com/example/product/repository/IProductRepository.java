package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where delete_status = false", nativeQuery = true)
    List<Product> findAll();

    @Query(value = "select * from product where product_name like %:nameSearch% and delete_status = false", nativeQuery = true)
    Page<Product> searchProduct(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Modifying
    @Query(value = "update product set delete_status = true where product_id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") Integer id);
}
