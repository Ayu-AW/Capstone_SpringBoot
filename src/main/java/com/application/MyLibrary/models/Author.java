package com.application.MyLibrary.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", length = 150, nullable = false,unique = true)
    private String name;

    @Column(name="description", length = 250, nullable = false)
    private String description;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<Book>();



}
