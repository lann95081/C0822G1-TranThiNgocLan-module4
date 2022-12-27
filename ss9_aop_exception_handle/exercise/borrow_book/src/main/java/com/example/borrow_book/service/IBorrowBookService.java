package com.example.borrow_book.service;

import com.example.borrow_book.model.BorrowBook;

public interface IBorrowBookService {
    void save(BorrowBook borrowBook);

    BorrowBook findByCode(String code);

    void remove(Integer id);
}
