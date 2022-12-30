package com.example.blog_webservice.service;

import com.example.blog_webservice.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
