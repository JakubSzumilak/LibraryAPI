package com.Biblioteka.BibliotekaAPI.Models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.id > :bottomInclusive AND b.id < :topInclusive")
    List<Book> GetBooks(int bottomInclusive, int topInclusive);
}
