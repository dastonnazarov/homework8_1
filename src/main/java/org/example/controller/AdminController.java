package org.example.controller;


import org.example.service.BookService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AdminController {
    public Scanner scannerN = new Scanner(System.in);
    public   Scanner scannerS = new Scanner(System.in);
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    @Autowired BookController bookController;


    // admin service
    public void adminSectionMenu() {
        System.out.println("--------------------  Library Menu  ----------------");
        System.out.println("1.Add Student");
        System.out.println("2.Student List");
        System.out.println("3.Delete Student");
        System.out.println("4.Student Taken book");
        System.out.println("5.BookTaken History");
        System.out.println("6.Add Book");
        System.out.println("7.Book List");
        System.out.println("8.Delete book");
        System.out.println("0.Exit");

    }

    public void adminStart() {
        while (true) {
            adminSectionMenu();
            Integer option = getAction();
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentList();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentTakenBook();
                    break;
                case 5:
                    bookTakenHistory();
                    break;
                case 6:
                    addBook();
                    break;
                case 7:
                    adminBookList();
                    break;
                case 8:
                    deleteBook();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("wrong option!!!");
                    break;
            }
        }
    }

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scannerS.nextLine();

        System.out.print("Enter surname: ");
        String surname = scannerS.nextLine();

        System.out.print("Enter phone: ");
        String phone =scannerS.nextLine();

        System.out.print("Enter birthDate: ");
        String birthDate =scannerS.nextLine();

        studentService.addStudent(name, surname, phone, birthDate);
    }

    private void studentList() {
        studentService.studentList();
    }

    private void deleteStudent() {
        System.out.println("Enter student Id: ");
        Integer id =scannerN.nextInt();

        studentService.deleteStudent(id);
    }

    private void bookTakenHistory() {

    }

    private void studentTakenBook() {

    }

    private void addBook() {
      bookController.addBook();
    }

    private void adminBookList() {
        bookService.adminAllBookList();
    }

    public void deleteBook() {
      bookController.deleteBook();
    }

    //***********************        menu section ******************
    public void start() {
        boolean b = true;
        int act;
        while (b) {
            menu();
            act = getAction();
            switch (act) {
                case 1 -> login();
                case 0 -> b = false;
                default -> System.out.println("wrong option!!!");
            }
        }
    }

    private void login() {
        System.out.println("Enter phone: ");
        String phone = scannerS.nextLine();
        studentService.isAdminOrStudent(phone);
    }

    public void menu() {
        System.out.println("** Menu **\n" +
                "1. LogIn\n" +
                "0. Exit");
    }

    public Integer getAction() {
        System.out.print("enter action: ");
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        return number;
    }

}
