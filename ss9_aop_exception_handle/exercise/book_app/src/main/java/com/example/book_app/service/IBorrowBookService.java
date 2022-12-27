package com.example.book_app.service;

import com.example.book_app.model.BorrowBook;

public interface IBorrowBookService {
    void save(BorrowBook borrowBook);

    BorrowBook findByCode(String code);

    void remove(Integer id);
}
