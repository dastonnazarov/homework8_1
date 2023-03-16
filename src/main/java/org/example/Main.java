package org.example;


import org.example.config.Config;
import org.example.controller.AdminController;
import org.example.db.Database;
import org.example.dto.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {


    public static void main(String[] args) {
           Database.initAdmins();
//        Database.createBookTable();
//        Database.createStudentTable();
//        Database.createStudentBookTable();
//
//       ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        AdminController adminController = (AdminController) context.getBean("adminController");
//       adminController.start();


        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();


//        EmployeeEntity e1 = new EmployeeEntity();
//        e1.setFirstName("Guarov");
//        e1.setLastName("Chawla");


        AdminController adminController = new AdminController();
        session.save(adminController);
        transaction.commit();


        factory.close();
        session.close();
    }
}
