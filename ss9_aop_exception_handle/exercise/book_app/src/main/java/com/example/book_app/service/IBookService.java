package com.example.book_app.service;

import com.example.book_app.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);
}
