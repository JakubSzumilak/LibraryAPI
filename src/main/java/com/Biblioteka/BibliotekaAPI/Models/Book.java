package com.Biblioteka.BibliotekaAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private String isbn;
    private int publication_year;

    public Book(String title, String author, String isbn, int publication_year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication_year = publication_year;
    }
}
