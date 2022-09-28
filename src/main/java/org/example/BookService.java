package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById (int id) {
        return bookRepository.findById(id);
    }

    public Book getBookByTitle (String title) {
        return bookRepository.findByTitle(title);
    }

//    @Autowired
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }
}
