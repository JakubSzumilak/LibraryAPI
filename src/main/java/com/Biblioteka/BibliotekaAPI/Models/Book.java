package com.Biblioteka.BibliotekaAPI.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false)
    private int publication_year;
    @OneToOne(mappedBy = "book")
    private BookCopy bookCopy;

    public Book(String title, String author, String isbn, int publication_year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication_year = publication_year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publication_year=" + publication_year +
                '}';
    }
}
