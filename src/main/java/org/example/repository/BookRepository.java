package org.example.repository;

import org.example.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public void addBook(Book book) {
        String sql = "insert into book (title,author,publishYear,amount) values('%s','%s',now(),%d)";
        sql = String.format(sql, book.getTitle(), book.getAuthor(), book.getAmount());
        int update = jdbcTemplate.update(sql);
        System.out.println(update);
    }

    public Book getBookById(Integer id) {
        String query = "Select * FROM book Where id = " + id;
        List<Book> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Integer deleteBook(Integer id) {
        String sql = "delete from book where id = '%s'";
        sql = String.format(sql, id);
        return jdbcTemplate.update(sql);
    }

    public List<Book> getAllBookList() {
        String query = "select * from book";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
    }




}
