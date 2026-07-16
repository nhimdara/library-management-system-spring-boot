package com.example.librarymanagement;

import com.example.librarymanagement.dto.BorrowRequest;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.BorrowRecordRepository;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.service.impl.BorrowServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BorrowServiceTest {
    private final BorrowRecordRepository borrowRecordRepository = mock(BorrowRecordRepository.class);
    private final StudentRepository studentRepository = mock(StudentRepository.class);
    private final BookRepository bookRepository = mock(BookRepository.class);
    private final BorrowServiceImpl service = new BorrowServiceImpl(borrowRecordRepository, studentRepository, bookRepository);

    @Test
    void borrowingReducesAvailableCopies() {
        Student student = Student.builder().id(1L).fullName("Student").build();
        Book book = Book.builder().id(1L).title("Book").availableCopies(2).totalCopies(2).build();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(borrowRecordRepository.findByStudentIdAndReturnedFalse(1L)).thenReturn(List.of());
        when(borrowRecordRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        service.borrow(new BorrowRequest(1L, 1L));

        assertThat(book.getAvailableCopies()).isEqualTo(1);
        verify(bookRepository).save(book);
    }
}
