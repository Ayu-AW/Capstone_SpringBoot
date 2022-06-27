package com.application.MyLibrary.data;

import com.application.MyLibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
