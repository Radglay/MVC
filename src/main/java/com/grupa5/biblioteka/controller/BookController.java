package com.grupa5.biblioteka.controller;

import com.grupa5.biblioteka.model.Book;
import com.grupa5.biblioteka.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


//    @GetMapping
//    @ResponseBody
//    public Iterable<Book> getBooks() {
//        return bookService.getBooks();
//    }

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("message", "Biblioteka");
        model.addAttribute("bookList", bookService.getBooks());
        return "books";
    }

    @GetMapping("/{id}")
    public String getUsers(@PathVariable Long id, Model model) throws SQLException {
        model.addAttribute("message", "Uzytkownicy");
        model.addAttribute("userList", bookService.getUsersByBookId(id));

        return "users";
    }
}
