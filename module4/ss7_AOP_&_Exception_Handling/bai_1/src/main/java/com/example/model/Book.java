package com.example.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
@Entity
@Table(name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "content")
    private String content;
    @Column(name = "quantity")
    private int quantity;

    public Book() {
    }

    public Book(int id, String bookName, String content, int quantity) {
        this.id = id;
        this.bookName = bookName;
        this.content = content;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
