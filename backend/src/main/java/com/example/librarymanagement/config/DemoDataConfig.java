package com.example.librarymanagement.config;

import com.example.librarymanagement.book.Book;
import com.example.librarymanagement.book.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoDataConfig {

    @Bean
    CommandLineRunner seedBooks(BookRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Book("Clean Code", "Robert C. Martin", "9780132350884", true));
                repository.save(new Book("The Pragmatic Programmer", "David Thomas and Andrew Hunt", "9780135957059", true));
                repository.save(new Book("Designing Data-Intensive Applications", "Martin Kleppmann", "9781449373320", false));
            }
        };
    }
}
