package com.Biblioteka.BibliotekaAPI.Controllers;

import com.Biblioteka.BibliotekaAPI.Models.Book;
import com.Biblioteka.BibliotekaAPI.Models.BookCopy;
import com.Biblioteka.BibliotekaAPI.Services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class FirstController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/api/auth/login")
    public String login()
    {
        return "Signing in...";
    }

    @RequestMapping(path = "/api/books")
    public String books(Model model)
    {
        model.addAttribute("books", bookService.GetBooks(0, 5));
        return "books";
    }

    @RequestMapping(path = "/api/books/{id}")
    public String book(@PathVariable int id, Model model)
    {
        model.addAttribute("book", bookService.GetBook(id));
        return "book";
    }

    @GetMapping("api/books/search")
    public String findABook()
    {
        return "search";
    }

    @GetMapping("api/books/result")
    public String result(Model model,
            @RequestParam String availability,
            @RequestParam String author,
            @RequestParam String title,
            @RequestParam String isbn,
            @RequestParam String year)
    {
        int year_int = (year.isEmpty())? 0 : Integer.parseInt(year);
        Book pattern = new Book(title, author, isbn, year_int);
        BookCopy patternCopy = new BookCopy();
        patternCopy.setStatus((availability.equalsIgnoreCase("any") ? null : availability.toLowerCase()));
        pattern.setBookCopy(patternCopy);
        model.addAttribute("books", bookService.GetBooks(pattern));
        return "result";
    }

    @GetMapping(path = "/api/borrowings")
    public String borrowBooks()
    {
        return "Borrowing...";
    }

    @GetMapping(path = "/api/users/{id}/borrowings")
    public String displayUserBorrowings(@PathVariable("id") String id)
    {
        return "Showing borrowings of the user with ID = " + id + "...";
    }
}
