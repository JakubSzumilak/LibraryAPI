package com.Biblioteka.BibliotekaAPI;

import com.Biblioteka.BibliotekaAPI.Models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		BorrowingRepository borrowingRepo = context.getBean(BorrowingRepository.class);
		BookCopyRepository bookCopyRepo = context.getBean(BookCopyRepository.class);
		BookRepository bookRepo = context.getBean(BookRepository.class);
		UserRepository userRepo = context.getBean(UserRepository.class);

		List<User> users = new ArrayList<>();
		users.add(new User("username1", "password1", "role1", "userone@gmail.com"));
		users.add(new User("username2", "password2", "role2", "usertwo@gmail.com"));
		users.add(new User("username3", "password3", "role3", "userthree@gmail.com"));
		users.add(new User("username4", "password4", "role4", "userfour@gmail.com"));
		users.add(new User("username5", "password5", "role5", "userfive@gmail.com"));
		userRepo.saveAll(users);

		List<Book> books = new ArrayList<>();
		books.add(new Book("book title 1", "book author 1", "isbn1234567890", 2000));
		books.add(new Book("book title 2", "book author 2", "1234577890isbn", 2000));
		books.add(new Book("book title 3", "book author 3", "12345isbn67890", 2000));
		books.add(new Book("book title 4", "book author 4", "i123s45b6789n0", 2000));
		books.add(new Book("book title 5", "book author 5", "1234is5bn67890", 2000));
		bookRepo.saveAll(books);

		List<BookCopy> bookCopies = new ArrayList<>();
		bookCopies.add(new BookCopy(books.get(0), "available"));
		bookCopies.add(new BookCopy(books.get(1), "unavailable"));
		bookCopies.add(new BookCopy(books.get(2), "unavailable"));
		bookCopies.add(new BookCopy(books.get(3), "available"));
		bookCopies.add(new BookCopy(books.get(4), "available"));
		bookCopyRepo.saveAll(bookCopies);

//		List<Borrowing> borrowings = new ArrayList<>();
//		borrowings.add(new Borrowing(bookCopies.get(0), users.get(0), LocalDate.now(),LocalDate.now(),LocalDate.now()));
//		borrowings.add(new Borrowing(bookCopies.get(0), users.get(1), LocalDate.now(),LocalDate.now(),LocalDate.now().withYear(1)));
//		borrowings.add(new Borrowing(bookCopies.get(3), users.get(1), LocalDate.now(),LocalDate.now(),LocalDate.now().withYear(2)));
//		borrowings.add(new Borrowing(bookCopies.get(4), users.get(2), LocalDate.now(),LocalDate.now(),LocalDate.now().withYear(3)));
//		borrowings.add(new Borrowing(bookCopies.get(4), users.get(3), LocalDate.now(),LocalDate.now(),LocalDate.now().withYear(4)));
//		borrowingRepo.saveAll(borrowings);
		//BookCopy bookCopy, User user, Date borrow_date, Date due_date, Date return_date


		Scanner scanner = new Scanner(System.in);
		scanner.next();

		System.out.println("Users:");
		userRepo.findAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Books:");
		bookRepo.findAll().forEach(System.out::println);
		System.out.println("Book copies::");
		bookCopyRepo.findAll().forEach(System.out::println);
		System.out.println();
		System.out.println("Borrowings:");
		borrowingRepo.findAll().forEach(System.out::println);

		System.out.println("\n\n\n\t\t\tUsername = user");
		System.out.println("\t\t\tPassword = password\n\n\n");
	}



}
