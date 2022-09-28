package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class BookRepository {
    private List<Book> books;

    @PostConstruct
    public void init() {
        books = new ArrayList<>(Arrays.asList(
                new Book(1, "Invisible Monsters", "Chuck Palahniuk", 4.8, 12.3),
                new Book(2, "Under the Dome", "Stephen King", 4.6, 9.7),
                new Book(3, "Three comrades", "Remark", 4.8, 11.0),
                new Book(4, "The Thanatonauts", "Bernard Werber", 4.9, 13.2),
                new Book(5, "The Three Musketeers", "Alexandre Dumas", 4.7, 12.4)
        ));
    }

    public Book findById(int id) {
        return books.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(new Book());
    }

    public Book findByTitle(String title) {
        return books.stream().filter(p -> Objects.equals(p.getTitle(), title)).findFirst().orElse(new Book());
    }

    public List<Book> getBooks() {
        return books;
    }
}
