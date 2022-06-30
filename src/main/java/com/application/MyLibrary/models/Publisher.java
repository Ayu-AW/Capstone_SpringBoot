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
@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="publisherName", length = 100, nullable = false, unique = true)
    private String publisherName;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL )
    private Set<Book> books = new HashSet<Book>();

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
