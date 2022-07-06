package com.application.MyLibrary;


import com.application.MyLibrary.models.*;
import com.application.MyLibrary.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude={SecurityAutoConfiguration.class})
public class MyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLibraryApplication.class, args);
	}

	@Autowired
	BookService bookService;

	@Bean
	public CommandLineRunner initialCreate( ) {
		return(args) ->{
			Book b01 = new Book("A100", "Library Management", "Explains how to implement library system");
			Author au01 = new Author("AuthorName1", "Author description1");
			Category cat01 = new Category("Systems Book");
			Publisher pub01 = new Publisher("Pub incorporated");

			b01.addAuthor(au01);
			b01.addCategory(cat01);
			b01.addPublisher(pub01);
			bookService.createBook(b01);

			Book b02 = new Book("A101", "Information Management", "Teaches information system");
			Author au02 = new Author("AuthorName2", "Author description2");
			Category cat02 = new Category("InfSys Book");
			Publisher pub02 = new Publisher("Inf incorporated");
			b02.addAuthor(au02);
			b02.addCategory(cat02);
			b02.addPublisher(pub02);
			bookService.createBook(b02);



		};

	}

}
