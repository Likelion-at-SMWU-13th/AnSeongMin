package com.likelion.book_project.advice;

import com.likelion.book_project.exception.BookNotFoundException;
import com.likelion.book_project.exception.DuplicateBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 전역 예외 처리 담당
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class) // BookNotFoundException 발생 시 처리
    public ResponseEntity<ErrorDetails> handleBookNotFound() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("책을 찾을 수 없습니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(DuplicateBookException.class) // DuplicateBookException 발생 시 처리
    public ResponseEntity<ErrorDetails> handleDuplicateBook() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("이미 존재하는 책입니다.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }
}
