# Library Management System - Spring Boot Backend

A simple and efficient REST API for a Library Management System, built with Spring Boot and MongoDB. [cite_start]This project implements full CRUD (Create, Read, Update, Delete) operations and additional custom queries for managing a book inventory. [cite: 7, 8]

[cite_start]This project was developed as part of the Full-Stack Software Development lab. [cite: 5]

## ✨ Features

* **Full CRUD Operations:**
    * [cite_start]**Create:** Add a new book to the database. [cite: 70]
    * [cite_start]**Read:** Retrieve a list of all books or a single book by its ID. [cite: 72, 73]
    * [cite_start]**Update:** Modify the details of an existing book. [cite: 74]
    * [cite_start]**Delete:** Remove a book from the database by its ID. [cite: 75]
* **Custom API Endpoints:**
    * [cite_start]Find all books by a specific publication year. [cite: 76]
    * [cite_start]Get the genre of a specific book by its ID. [cite: 77]
    * [cite_start]Delete all books published in a specific year. [cite: 78]

## 🛠️ Tech Stack

* **Java**
* **Spring Boot**
* [cite_start]**Spring Web:** For creating RESTful API endpoints. [cite: 14]
* [cite_start]**Spring Data MongoDB:** For database integration and repositories. [cite: 15]
* [cite_start]**MongoDB Atlas:** Cloud-hosted NoSQL database. [cite: 7]
* [cite_start]**Lombok:** To reduce boilerplate code. [cite: 16]
* **Maven:** For project building and dependency management.

## 🚀 How to Run Locally

1.  **Clone the repository:**
    ```sh
    git clone [https://github.com/your-username/your-repository-name.git](https://github.com/your-username/your-repository-name.git)
    cd your-repository-name
    ```

2.  **Configure MongoDB:**
    * Open `src/main/resources/application.properties`.
    * Update the `spring.data.mongodb.uri` property with your own MongoDB Atlas connection string:
    ```properties
    spring.data.mongodb.uri=mongodb+srv://<db_username>:<db_password>@<your_cluster_url>/<db_name>?retryWrites=true&w=majority
    ```

3.  **Run the application:**
    * You can run the `LibraryApplication.java` file directly from your IDE.
    * Or, use Maven in your terminal:
    ```sh
    ./mvnw spring-boot:run
    ```

4.  **Access the API:**
    * The application will start (by default on `http://localhost:8080` or your configured port).
    * You can now use Postman or any API client to test the endpoints.

## 📖 API Endpoints

The base URL for the API is `/api/books`.

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/books` | Adds a new book to the library. |
| `GET` | `/api/books` | Retrieves a list of all books. |
| `GET` | `/api/books/{id}` | Fetches a single book by its ID. |
| `PUT` | `/api/books/{id}` | Updates an existing book's details. |
| `DELETE` | `/api/books/{id}` | Deletes a book by its ID. |
| `GET` | `/api/books/year/{year}` | Finds all books from a specific year. |
| `GET` | `/api/books/genre/{id}` | Gets the genre of a specific book. |
| `DELETE` | `/api/books/year/{year}` | Deletes all books from a specific year. |
