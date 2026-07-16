package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.BookRequest;
import com.example.librarymanagement.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    List<Book> search(String query);
    Book create(BookRequest request);
    Book update(Long id, BookRequest request);
    void delete(Long id);
}
