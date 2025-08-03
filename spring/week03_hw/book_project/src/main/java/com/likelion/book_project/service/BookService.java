package com.likelion.book_project.service;

import com.likelion.book_project.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }
}
