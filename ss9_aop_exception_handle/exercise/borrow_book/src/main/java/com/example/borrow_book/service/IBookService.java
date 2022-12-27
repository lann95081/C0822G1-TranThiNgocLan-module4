package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);
}
