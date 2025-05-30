package com.Biblioteka.BibliotekaAPI.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public BookCopy(Book book, String status) {
        this.book = book;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
