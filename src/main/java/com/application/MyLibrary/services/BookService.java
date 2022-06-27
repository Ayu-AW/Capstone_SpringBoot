package com.application.MyLibrary.services;
import com.application.MyLibrary.models.Book;
import com.application.MyLibrary.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Returns list of all books from the database
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
    // Returns a specific book fetched by a given id
    public Book findBookId(Long id){
        //Find the book by id
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));
        return book;
    }

    // Adds new book to the database
    public void createBook(Book book) {
        bookRepository.save(book);
    }
    // Deletes a specific a book by id
    public void deleteBook(Long id) {
        //Find the book by id
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found!"));
        bookRepository.deleteById(book.getId());
    }

}
