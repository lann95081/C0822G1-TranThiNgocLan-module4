package com.example.book_app.service.impl;

import com.example.book_app.model.BorrowBook;
import com.example.book_app.repository.IBorrowBookRepository;
import com.example.book_app.service.IBorrowBookService;
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
