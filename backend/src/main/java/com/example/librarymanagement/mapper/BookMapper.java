package com.example.librarymanagement.mapper;

import com.example.librarymanagement.dto.BookRequest;
import com.example.librarymanagement.entity.Book;

public final class BookMapper {
    private BookMapper() {
    }

    public static Book toEntity(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setTotalCopies(request.totalCopies());
        book.setAvailableCopies(request.totalCopies());
        return book;
    }
}
