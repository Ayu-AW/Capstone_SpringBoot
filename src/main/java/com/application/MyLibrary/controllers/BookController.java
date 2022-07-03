package com.application.MyLibrary.controllers;

import com.application.MyLibrary.models.Book;
import com.application.MyLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    // Method to return all books from the db on the web browser
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks(); //list of all books
        model.addAttribute("books", books); // List added to model object
        return "books";
    }

    // Method to view book details
    @GetMapping("/book/{id}")
    public String findBook(Long id, Model model) {
        Book book = bookService.findBookId(id);
        model.addAttribute("book", book);
        return "list-book";
    }
}
