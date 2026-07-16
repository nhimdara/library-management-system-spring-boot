package com.example.librarymanagement;

import com.example.librarymanagement.dto.BookRequest;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.CategoryRepository;
import com.example.librarymanagement.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {
    private final BookRepository bookRepository = mock(BookRepository.class);
    private final CategoryRepository categoryRepository = mock(CategoryRepository.class);
    private final BookServiceImpl service = new BookServiceImpl(bookRepository, categoryRepository);

    @Test
    void createsBookWithAllCopiesAvailable() {
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Book book = service.create(new BookRequest("Clean Code", "Robert Martin", "123", 5, null));
        assertThat(book.getAvailableCopies()).isEqualTo(5);
        verify(bookRepository).save(book);
    }
}
