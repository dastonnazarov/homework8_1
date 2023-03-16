package org.example.dto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studentBook")
public class StudentBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "createDate")
    private LocalDate createDate;

    @Column(name = "createDate")
    private String status;

    @Column(name = "returnedDate")
    private LocalDate returnedDate;

    @Column(name = "duration")
    private Integer duration;


    public StudentBook() {
    }


    public StudentBook(Integer id, Integer student_id, Integer book_id, LocalDate createDate, String status, LocalDate returnedDate, Integer duration) {
        this.sId = id;
        this.student_id = student_id;
        this.book_id = book_id;
        this.createDate = createDate;
        this.status = status;
        this.returnedDate = returnedDate;
        this.duration = duration;
    }

    public Integer getId() {
        return sId;
    }

    public void setId(Integer id) {
        this.sId = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public LocalDate getLocalDate() {
        return createDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.createDate = localDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "StudentBook{" +
                "id=" + sId +
                ", student=" + student_id +
                ", book_id=" + book_id +
                ", localDate=" + createDate +
                ", status=" + status +
                ", returnedDate=" + returnedDate +
                ", duration=" + duration +
                '}';
    }

}
