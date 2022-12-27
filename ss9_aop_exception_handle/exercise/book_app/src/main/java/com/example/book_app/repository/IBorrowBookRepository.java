package com.example.book_app.repository;

import com.example.book_app.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    BorrowBook findByCode(String code);
}
