package com.example.library.repository;
import com.example.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    // Spring Data MongoDB will automatically create the query for these methods
    // based on the method name.

    // Finds all books by a specific publication year
    List<Book> findByPublicationYear(int year);

    // Deletes all books by a specific publication year
    void deleteByPublicationYear(int year);
}