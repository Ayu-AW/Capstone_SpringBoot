package com.application.MyLibrary.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="ISBN", length = 50, nullable = false,unique = true)
    private String isbn;

    @Column(name="bookName", length = 100, nullable = false)
    private String bookName;

    @Column(name="description", length = 250, nullable = false)
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL}) //Whatever CURD operation we do in books will be directly be applied in authors
    @JoinTable(name = "books_authors",
        joinColumns = {@JoinColumn(name="book_id")},
        inverseJoinColumns = {@JoinColumn(name  = "author_id" )})
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = {CascadeType.ALL}) //Whatever CURD operation we do in books will be directly be applied in authors
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name  = "category_id" )})
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = {CascadeType.ALL}) //Whatever CURD operation we do in books will be directly be done in authors
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name="book_id")},
            inverseJoinColumns = {@JoinColumn(name  = "publisher_id" )})
    private Set<Publisher> publishers = new HashSet<Publisher>();

    public Book(String isbn, String bookName, String description) {
        this.isbn = isbn;
        this.bookName = bookName;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
