package org.example.controller;


import org.example.dto.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {
    @Autowired
    AdminController adminController;
    @Autowired
    BookService bookService;
    public void addBook() {
        System.out.println("Enter title");
        String title = adminController.scannerS.nextLine();

        System.out.println("Enter author");
        String author =adminController.scannerS.nextLine();

        System.out.println("Enter amount");
        Integer amount = adminController.scannerN.nextInt();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        book.setAmount(amount);
        bookService.addBook(book);
    }

    public void deleteBook() {
        System.out.println("Enter book Id: ");
        Integer id = adminController.scannerN.nextInt();

        Book book = new Book();
        book.setId(id);
        bookService.deleteBook(book);
    }
}
