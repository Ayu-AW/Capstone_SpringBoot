package com.application.MyLibrary.controllers;

import com.application.MyLibrary.models.Book;
import com.application.MyLibrary.services.AuthorService;
import com.application.MyLibrary.services.BookService;
import com.application.MyLibrary.services.CategoryService;
import com.application.MyLibrary.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    // Method to return all books from the db on the web browser
    public String findAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks(); //list of all books
        model.addAttribute("books", books); // List added to model object
        return "books";
    }


    // Method to view book details
    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }
    // Deleting a book
    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.deleteBook(id);
        // Refreshed set of data after deletion
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }
    // Method to edit  a book detail
    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "update-book";
    }
    // Method to save the update/edit
    @PostMapping("/save-update/{id}")
    //BindingResult is validation
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

    // Method to add new book into the list
    @GetMapping("/add-book")
    public String addBook(Book book, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("authors", authorService.findAllAuthors());
        return "add-book";
    }
    //Method to save the added book
    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookService.createBook(book);
        model.addAttribute("books", bookService.findAllBooks());
        return "redirect:/books";
    }

}
