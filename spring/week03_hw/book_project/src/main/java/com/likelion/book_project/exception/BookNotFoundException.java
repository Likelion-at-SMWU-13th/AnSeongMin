package com.likelion.book_project.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        System.out.println(message);
    }
}
