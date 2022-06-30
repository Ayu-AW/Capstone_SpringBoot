package com.application.MyLibrary.services;

import com.application.MyLibrary.data.AuthorRepository;
import com.application.MyLibrary.models.Author;
import com.application.MyLibrary.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired //Initializes automatically
    private AuthorRepository authorRepository;

    // Method to fetch list of all authors
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    // Method for getting a specific author
    public Author findAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return  author;
    }

    // Method to add a new author
    public void createAuthor (Author author) {
        authorRepository.save(author);
    }

    // Method to update a specific author
    public void updateAuthor(Author author) {
        authorRepository.save(author);

    }
    // Method to delete author by id
    public void deleteAuthor (Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found!"));
        authorRepository.deleteById(author.getId());
    }


}



