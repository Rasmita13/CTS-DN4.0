package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private String label;
    private BookRepository bookRepository;

    public BookService(String label) {
        this.label = label;
        System.out.println("Constructor injection: " + label);
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter injection: BookRepository injected.");
    }

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
