package com.likelion.book_project.exception;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String message) {
        System.out.println(message);
    }
}
