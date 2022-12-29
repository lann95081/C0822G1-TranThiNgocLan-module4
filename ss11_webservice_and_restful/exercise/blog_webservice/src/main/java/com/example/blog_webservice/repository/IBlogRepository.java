package com.example.blog_webservice.repository;

import com.example.blog_webservice.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByCategory_CategoryId(Integer categoryId);
}
