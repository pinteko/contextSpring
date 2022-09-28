package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    List<Book> books = new ArrayList<>();

    public Cart() {}

//    public Cart(Book book) {
//        books.add(book);
//    }

    public void addBook(Book book) {
        if (book != null) {
        books.add(book);}
    }

    public void deleteBook(Book book) {
        if (book != null) {
            books.remove(book);}
    }

    public List<Book> getBooks() {
        return books;
    }
}
