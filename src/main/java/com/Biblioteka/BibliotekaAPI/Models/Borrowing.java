package com.Biblioteka.BibliotekaAPI.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate borrow_date;
    private LocalDate due_date;
    private LocalDate return_date;

    @OneToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Borrowing{" +
                "borrow_date=" + borrow_date +
                ", due_date=" + due_date +
                ", return_date=" + return_date +
                ", bookCopy=" + bookCopy +
                ", user=" + user +
                '}';
    }

    public Borrowing(BookCopy bookCopy, User user, LocalDate borrow_date, LocalDate due_date, LocalDate return_date) {
        this.bookCopy = bookCopy;
        this.user = user;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
    }
}
