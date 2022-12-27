package com.example.book_app.controller;

import com.example.book_app.model.Book;
import com.example.book_app.service.IBookService;
import com.example.book_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "/list";
    }
}
