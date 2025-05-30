package com.Biblioteka.BibliotekaAPI.Services;

import com.Biblioteka.BibliotekaAPI.Models.Book;
import com.Biblioteka.BibliotekaAPI.Models.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book>  GetBooks(int bottomInclusive, int topInclusive)
    {
        return bookRepository.GetBooks(bottomInclusive, topInclusive);
    }

    public Book GetBook(long id)
    {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(new Book());
    }

    public List<Book> GetBooks(Book pattern)
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(b -> {

            // check if title matches (if provided)
            if (    !(pattern.getTitle() == null) &&
                    !pattern.getTitle().isEmpty() &&
                    !pattern.getTitle().equalsIgnoreCase(b.getTitle()))
                return;

            // check if author matches (if provided)
            if (    !(pattern.getAuthor() == null) &&
                    !pattern.getAuthor().isEmpty() &&
                    !pattern.getAuthor().equalsIgnoreCase(b.getAuthor()))
                return;

            // check if isbn matches (if provided)
            if (    !(pattern.getIsbn() == null) &&
                    !pattern.getIsbn().isEmpty() &&
                    !pattern.getIsbn().equalsIgnoreCase(b.getIsbn()))
                return;

            // check if publication year matches (if provided)
            if (    pattern.getPublication_year() != 0 &&
                    pattern.getPublication_year() != b.getPublication_year())
                return;

            // check if availability matches (if provided)
            if (    !(pattern.getBookCopy() == null) &&
                    !(pattern.getBookCopy().getStatus() == null) &&
                    !pattern.getBookCopy().getStatus().isEmpty() &&
                    !pattern.getBookCopy().getStatus().equalsIgnoreCase(b.getBookCopy().getStatus()))
                return;

            books.add(b);
        });
        return books;
    }

}
