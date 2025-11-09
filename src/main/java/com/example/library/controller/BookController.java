package com.example.library.controller;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Defines this as a REST controller
@RequestMapping("/api/books") // Base URL for all endpoints in this class
public class BookController {

    @Autowired // Injects the BookService
    private BookService bookService;

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return bookService.getBookById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        try {
            Book updatedBook = bookService.updateBook(id, bookDetails);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // --- Custom Query Endpoints ---

    // Find books by publication year
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Book>> getBooksByYear(@PathVariable int year) {
        List<Book> books = bookService.getBooksByPublicationYear(year);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get genre by book ID
    @GetMapping("/genre/{id}")
    public ResponseEntity<String> getBookGenreById(@PathVariable String id) {
        try {
            String genre = bookService.getBookGenreById(id);
            return new ResponseEntity<>(genre, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete all books by publication year
    @DeleteMapping("/year/{year}")
    public ResponseEntity<HttpStatus> deleteBooksByYear(@PathVariable int year) {
        bookService.deleteBooksByPublicationYear(year);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}