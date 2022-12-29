package com.example.blog_webservice.service;

import com.example.blog_webservice.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    List<Blog> findByCategory(Integer categoryId);
}
