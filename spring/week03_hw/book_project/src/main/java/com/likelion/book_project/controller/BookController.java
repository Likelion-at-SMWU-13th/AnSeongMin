package com.likelion.book_project.controller;

import com.likelion.book_project.model.Book;
import com.likelion.book_project.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Book API", description = "도서 목록 웹앱 API")
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @Operation(summary = "GET BOOK API", description = "등록된 모든 도서 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공")
    })
    @GetMapping("/books")
    public String viewBooks(Model model) {
        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }


    @Operation(summary = "POST BOOK API", description = "새로운 도서 등록")
    @Parameters({
            @Parameter(name = "title", description = "도서 제목", required = true),
            @Parameter(name = "author", description = "저자 이름", required = true),
            @Parameter(name = "price", description = "도서 가격", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "책 등록에 성공했습니다.", content= @Content(mediaType="application/json")),
            @ApiResponse(responseCode = "409", description = "중복된 책이 이미 존재합니다.", content= @Content(mediaType="application/json"))
    })
    @PostMapping("/books")
    public String addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int price,
            Model model
            ) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBook(book);

        var books = bookService.findAll();
        model.addAttribute("books", books);

        return "books.html";
    }
}
