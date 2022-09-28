package org.example;

import org.example.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Scanner scanner = new Scanner(System.in);
        BookService bookService = context.getBean(BookService.class);
        Cart cart = context.getBean(Cart.class);
        Book book;
        boolean stop = false;
        System.out.println("If you want to find book in the repository enter FIND");
        System.out.println("If you want to delete book from the cart enter DEL");
        System.out.println("If you want to change the cart enter CART");
        System.out.println("If you want to exit enter EXIT");
        showCart(cart);
        while (!stop) {
            String command = scanner.next();
            if (command.equalsIgnoreCase("find")) {
                book = findBook(bookService, scanner);
                if (book.getId() != 0) {
                System.out.println("Do you want to add book to your cart?  Y or N");
                if (scanner.next().equalsIgnoreCase("y")) {
                    cart.addBook(book);
                    showCart(cart);
                    System.out.println("What next?");
                }}
                else {
                    System.out.println("What next?");
                }
            }
            else if (command.equalsIgnoreCase("delete")) {
                System.out.println("Enter id of the book");
                int id;
                if (scanner.hasNext()) {
                    id = scanner.nextInt();
                    cart.deleteBook(bookService.getBookById(id));
                    showCart(cart);
                    System.out.println("What next?");
                }
            }
           else if (command.equalsIgnoreCase("cart")) {
                cart = context.getBean(Cart.class);
                showCart(cart);
            }
           else if (command.equalsIgnoreCase("exit")) {
                stop = true;
            }
        }
        scanner.close();
    }

    public static Book findBook(BookService bookService, Scanner scanner) {
        Book findBook = new Book();
        System.out.println("If you want to find book by id enter: 1");
        System.out.println("If you want to find book by title enter: 2");
        int number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        else {
            System.out.println("Incorrect value");
        }

        if (number == 1) {
                System.out.println("Print book id:");
                if (scanner.hasNextInt()) {
                    int id = scanner.nextInt();
                    findBook = bookService.getBookById(id);
                    if (findBook.getId() != 0) {
                    System.out.println(findBook);
                    return findBook; }
                    else {
                        System.out.println("Don't find the book");
                    }
                }
                else {System.out.println("Incorrect value");}
            }
        else if (number == 2) {
                System.out.println("Print book title:");
                if (scanner.hasNext()) {
                    String title = scanner.next();
                    findBook = bookService.getBookByTitle(title);
                    if (findBook.getId() != 0) {
                        System.out.println(findBook);
                        return findBook; }
                    else {
                        System.out.println("Don't find the book");
                    }
                }
            }
        else {
                System.out.println("Incorrect value");
            }
        return findBook;
    }

    public static void showCart(Cart cart) {
        List<Book> books = cart.getBooks();
        System.out.println("Your cart: ");
        System.out.println(books.stream().toList());
    }
}