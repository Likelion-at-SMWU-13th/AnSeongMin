package com.likelion.book_project.advice;

import com.likelion.book_project.exception.BookNotFoundException;
import com.likelion.book_project.exception.DuplicateBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException e) {
        return new ResponseEntity<>("존재하지 않는 책입니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateBookException.class)
    public ResponseEntity<String> handleDuplicateBook(DuplicateBookException e) {
        return new ResponseEntity<>("이미 존재하는 책입니다.", HttpStatus.CONFLICT);
    }




}
