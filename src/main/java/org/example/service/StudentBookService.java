package org.example.service;

import org.example.container.Comp;
import org.example.dto.Book;
import org.example.dto.StudentBook;
import org.example.repository.BookRepository;
import org.example.repository.StudentBookRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentBookRepository studentBookRepository;
    @Autowired
    StudentRepository studentRepository;


    public void studentTakeBook(Integer book_id, Integer amount, LocalDate createDate) {
        Book book = bookRepository.getBookById(book_id);
       // int counts = studentBookRepository.count();
        if (book == null) {
            System.out.println("Student olgan kitoblar mavjud emas!");
        }
      int count = studentTookBookCount(book_id);
        if (count >= 5) {
            System.out.println("sorry, you can not take book  ");
        }
//        if (book.getId() == book_id) {
//            int amountUpdate = book.getAmount() - amount;
//            studentBookRepository.updateBook(book,amountUpdate);
//        }

        StudentBook studentBooks = new StudentBook();
        studentBooks.setStudent_id(Comp.current_student.getId());
        studentBooks.setBook_id(book_id);
        studentBooks.setDuration(amount);
        studentBooks.setLocalDate(createDate);
        studentBooks.setStatus("TAKEN");
        studentBookRepository.addTakeStudentBook(studentBooks);
        System.out.println("student takes book successfully");
    }

    private int studentTookBookCount(Integer book_id) {
        int count = 0;
        for (StudentBook sb : studentBookRepository.getStudentTakeBookList()) {
            if (sb.getBook_id().equals(book_id) && sb.getStatus().equals("TAKEN")) {
                count++;
            }
        }
        return count;
    }

    public void sTakeBookList() {
        for (StudentBook sb : studentBookRepository.getStudentTakeBookList()) {
            if (sb != null && sb.getStatus().equals("TAKEN")) {
                System.out.println(sb.toString());
            }
        }
    }


    public StudentBook returnBook(Integer bookId ) {
       studentBookRepository.getStudentAndBookId(bookId,Comp.current_student.getId());
       return null;
    }
}
