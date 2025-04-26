package com.Biblioteka.BibliotekaAPI.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Borrowing {
    private long id;
    private long book_copy_id;
    private long user_id;
    private Date borrow_date;
    private Date due_date;
    private Date return_date;
}
