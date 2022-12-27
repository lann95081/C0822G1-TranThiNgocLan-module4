package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.BorrowBook;
import com.example.borrow_book.repository.IBorrowBookRepository;
import com.example.borrow_book.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookSevice implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository iBorrowBookRepository;

    @Override
    public void save(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
    }

    @Override
    public BorrowBook findByCode(String code) {
        return iBorrowBookRepository.findByCode(code);
    }

    @Override
    public void remove(Integer id) {
        iBorrowBookRepository.deleteById(id);
    }
}
