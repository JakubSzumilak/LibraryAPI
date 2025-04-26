package com.Biblioteka.BibliotekaAPI.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping(path = "/api/auth/login")
    public String login()
    {
        return "Signing in...";
    }

    @GetMapping(path = "/api/books")
    public String books()
    {
        return "Books...";
    }

    @GetMapping(path = "/api/books/search")
    public String searchBooks()
    {
        return "Searching books...";
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
