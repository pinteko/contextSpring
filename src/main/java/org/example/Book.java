package org.example;

public class Book {
    private int id;
    private String title;
    private String author;
    private double rating;
    private double price;

    public Book() {}

    public Book(int id, String title, String author, double rating, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id:" + id + " " +
                '\"' + title + '\"' +
                " " + author + " (" +
                "rating=" + rating + ").";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
