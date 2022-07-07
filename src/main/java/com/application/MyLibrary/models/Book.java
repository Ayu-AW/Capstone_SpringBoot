package com.application.MyLibrary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="isbn", length = 50, nullable = false,unique = true)
    private String isbn;


    @Column(name="name", length = 100, nullable = false)
    private String name;


    @Column(name="description", length = 250, nullable = false)
    private String description;

    //Whatever CURD operation we do in books will  directly be applied in authors
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors",
        joinColumns = {@JoinColumn(name="book_id")},
        inverseJoinColumns = {@JoinColumn(name  = "author_id" )})
    private Set<Author> authors = new HashSet<Author>();

    //Whatever CURD operation we do in books will  directly be applied in categories
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name  = "category_id" )})
    private Set<Category> categories = new HashSet<Category>();

    //Whatever CURD operation we do in books will  directly be done in publishers
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name  = "publisher_id" )})
    private Set<Publisher> publishers = new HashSet<Publisher>();

    //Whatever CURD operation we do in books will  directly be applied in users
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_users",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name  = "user_id" )})
    private Set<UsersModel> users_table = new HashSet<UsersModel>();

    // Constructor
    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    // method to remove bidirectionally
    public void removePublisher(Publisher publisher) {
        this.publishers.remove(publisher); // removing from the set of publishers
        publisher.getBooks().remove(publisher); //getting all the books and removing from the object
    }
    // method to add bidirectionally
    public void addPublisher(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    // method to remove bidirectionally
    public void removeAuthor(Author author) {
        this.authors.remove(author); // removing from the set of authors
        author.getBooks().remove(author); //getting all the books and removing from the object
    }
    // method to add bidirectionally
    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }

    // method to remove bidirectionally
    public void removeCategory(Category category) {
        this.authors.remove(category); // removing from the set of category
        category.getBooks().remove(category); //getting all the books and removing from the object
    }
    // method to add bidirectionally
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
    }


}
