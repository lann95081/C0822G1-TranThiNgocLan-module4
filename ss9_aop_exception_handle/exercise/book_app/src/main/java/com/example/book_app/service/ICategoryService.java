package com.example.book_app.service;

import com.example.book_app.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
