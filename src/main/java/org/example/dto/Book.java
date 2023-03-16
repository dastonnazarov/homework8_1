package org.example.dto;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publishYear")
    private LocalDate publishYear;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "visible")
    private boolean visible;

    public Book() {
    }


    public Book(Integer id, String title, String author, LocalDate publishYear, Integer amount, boolean visible) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.amount = amount;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(LocalDate publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount=" + amount +
                ", visible=" + visible +
                '}';
    }
}
