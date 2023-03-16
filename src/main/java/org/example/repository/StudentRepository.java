package org.example.repository;


import org.example.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveStudent(Student student) {
        String sql = "insert into student (name,surname,phone,birth_date,role ) values('%s','%s','%s','%s','%s')";
        sql = String.format(sql, student.getName(), student.getSurname(), student.getPhone(), student.getBirthDate(),student.getRole());
        int update = jdbcTemplate.update(sql);
        return update;
    }


    public Integer deleteStudent(Integer id) {
        String sql = "delete from student where id = '%s'";
        sql = String.format(sql, id);
        return jdbcTemplate.update(sql);
    }

    public List<Student> getAllStudent() {
        String query = "select * from student";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
    }


    public Student getStudentByPhone(String phone) {
        String sql = String.format("SELECT * FROM student Where phone = '%s';", phone);
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Student getStudentById(Integer id) {
        String query = "select * from where id=" + id;
        Student student = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class));
        return student;
    }

}
