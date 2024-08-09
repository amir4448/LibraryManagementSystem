package com.example.LibraryManagementSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String title;
    private String author;
    private int publication_year;
    private String isbn;

    public Book(){}
    public Book(Long ID, String title, String author, int publication_year, String isbn) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.isbn=isbn;
    }

    public Book(String title, String author, int publication_year, String isbn) {
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.isbn=isbn;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication_year=" + publication_year + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
