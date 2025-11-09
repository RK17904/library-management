package com.example.library.service;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component
public class BookServiceImpl implements BookService {

    @Autowired // Injects the BookRepository
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(String id, Book bookDetails) {
        // Find the existing book or throw an exception
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        // Update the fields
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setShelfLocation(bookDetails.getShelfLocation());

        // Save the updated book
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByPublicationYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public String getBookGenreById(String id) {
        // Find the book or throw an exception
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        return book.getGenre();
    }

    @Override
    public void deleteBooksByPublicationYear(int year) {
        bookRepository.deleteByPublicationYear(year);
    }
}