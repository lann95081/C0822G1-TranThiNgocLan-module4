package com.example.borrow_book.repository;

import com.example.borrow_book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    BorrowBook findByCode(String code);
}
