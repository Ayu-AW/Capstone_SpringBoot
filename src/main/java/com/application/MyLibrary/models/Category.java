package com.application.MyLibrary.models;

import javax.persistence.*;
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
@NoArgsConstructor
@Entity @Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="categoryName", length = 100, nullable = false, unique = true)
    private String categoryName;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL )
    private Set<Book> books = new HashSet<Book>();

}
