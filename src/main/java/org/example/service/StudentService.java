package org.example.service;


import org.example.container.Comp;
import org.example.controller.AdminController;
import org.example.controller.StudentBookController;
import org.example.dto.Student;
import org.example.enums.StudentRole;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private StudentBookController studentBookController;


    public void isAdminOrStudent(String phone) {
        Student exist = studentRepository.getStudentByPhone(phone);
        if (exist == null) {
            System.err.println("not found!!!");
        } else if (exist.getPhone().equals("4477")) {
            adminController.adminStart();
        } else {
            Comp.current_student = exist;
            studentBookController.studentStart();
        }
    }


    public void studentList() {
        System.out.println("----------   Student List ----------");
        List<Student> cards = studentRepository.getAllStudent();
        cards.forEach(student -> System.out.println(student));
    }

    public void deleteStudent(Integer id) {
        Integer integer = studentRepository.deleteStudent(id);
        if (integer == 1) {
            System.out.println("student is successfully deleted");
        } else {
            System.out.println("not found");
        }

    }

    public void addStudent(String name, String surname, String phone, String birthDate) {
        Student exist = studentRepository.getStudentByPhone(phone);

        if (exist != null) {
            System.out.println("sorry that student already exist!!!");
            adminController.adminSectionMenu();

        } else {

            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setPhone(phone);
            student.setBirthDate(birthDate);
            student.setRole(StudentRole.STUDENT);

            studentRepository.saveStudent(student);
            System.out.println("Student is create successfully");
        }
    }

}


