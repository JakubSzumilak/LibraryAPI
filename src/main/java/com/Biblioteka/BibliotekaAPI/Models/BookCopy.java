package com.Biblioteka.BibliotekaAPI.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class BookCopy {
    private long id;
    private long book_id;
    private String status;
}
