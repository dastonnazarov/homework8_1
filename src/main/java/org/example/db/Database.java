package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void createStudentTable() {
        try {
            String studentTable = "create table if not exists student( " +
                    "                id serial primary key, " +
                    "                name varchar(25) not null, " +
                    "                surname varchar(25) not null, " +
                    "                phone varchar(13) , " +
                    "                birth_date varchar not null," +
                    "                role varchar not null default 'STUDENT'," +
                    "                visible boolean default 'true'" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(studentTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createBookTable() {
        try {
            String bookTable = "create table if not exists book( " +
                    "                id serial primary key, " +
                    "                title varchar not null, " +
                    "                author varchar  not null, " +
                    "                publishYear varchar default 'BLOCK', " +
                    "                amount real," +
                    "                visible boolean default true" +
                    "         );";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(bookTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createStudentBookTable() {
        try {
            String studentBookTable = "create table if not exists studentBook( " +
                    "                id serial primary key, " +
                    "                student_id Integer not null, " +
                    "                book_id Integer  not null, " +
                    "                createdDate date, " +
                    "                status varchar," +
                    "                returnedDate date," +
                    "                duration Integer" +
                    "         );";

            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(studentBookTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initAdmins() {
        try {
            String profileTable = "insert into student(id,name,surname,phone,birth_date,role) " +
                    "values('-1','admin','adminov','4477', '2000-12-12','ADMIN') ON CONFLICT (id) DO NOTHING;";
            Connection con = getConnection();
            Statement statement = con.createStatement();
            statement.executeUpdate(profileTable);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            // 1
            Class.forName("org.postgresql.Driver");
            // 2-yo'l.
            return DriverManager.getConnection("jdbc:postgresql://localhost:5433/library", "postgres", "123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
