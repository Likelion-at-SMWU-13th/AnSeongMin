package com.likelion.seminar2.controller;

import com.likelion.seminar2.service.BookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String viewBooks(Model model) {
        var books = bookService.finaAll();
        model.addAttribute("books", books);

        return "products.html";
    }
}
