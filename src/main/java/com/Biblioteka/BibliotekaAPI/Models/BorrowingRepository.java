package com.Biblioteka.BibliotekaAPI.Models;

import org.springframework.data.repository.CrudRepository;

public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
}
