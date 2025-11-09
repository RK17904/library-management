package com.example.library.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "books") // Tells MongoDB to store this in a collection named "books"
@Data // Lombok: Generates getters, setters, toString()
@AllArgsConstructor // Lombok: Generates a constructor with all arguments
@NoArgsConstructor // Lombok: Generates a no-argument constructor
public class Book {

    @Id // Marks this field as the primary key
    private String id;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String shelfLocation;
}
