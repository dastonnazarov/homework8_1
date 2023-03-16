package org.example.service;


import org.example.controller.AdminController;
import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AdminController adminController;

    public void addBook(Book book) {
        Book exist = bookRepository.getBookById(book.getId());
        if (exist != null) {
            System.out.println("sorry that book already exist!!!");
            adminController.adminSectionMenu();

        } else {
            book.setPublishYear(LocalDate.now());
            bookRepository.addBook(book);
            System.out.println("Book is create successfully");
        }
    }

    public void adminAllBookList() {
        System.out.println("------------------    admin  book   list    -----------------------");

        List<Book> bookList = bookRepository.getAllBookList();
        bookList.forEach(book -> System.out.println(book));
    }

    public void deleteBook(Book book) {
        Book exist = bookRepository.getBookById(book.getId());
        if (exist == null) {
            System.out.println("not fount!!!");
            adminController.adminSectionMenu();
        }else {
            bookRepository.deleteBook(book.getId());
            System.out.println("book deleted successfully ");
        }
    }
}
