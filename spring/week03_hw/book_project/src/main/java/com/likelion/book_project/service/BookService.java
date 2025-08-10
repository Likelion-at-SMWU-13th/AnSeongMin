package com.likelion.book_project.service;

import com.likelion.book_project.exception.BookNotFoundException;
import com.likelion.book_project.exception.DuplicateBookException;
import com.likelion.book_project.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getTitle().equals(book.getTitle())) {
                throw new DuplicateBookException(book.getTitle()+"은 이미 존재하는 책입니다.");
            }
        }
        books.add(book);
    }


    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("책을 찾을 수 없습니다.");
    }
}
