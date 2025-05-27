package com.Biblioteka.BibliotekaAPI.Models;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
