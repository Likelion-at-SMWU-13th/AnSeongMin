package com.likelion.seminar2.service;

import com.likelion.seminar2.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> finaAll() {
        return books;
    }
}
