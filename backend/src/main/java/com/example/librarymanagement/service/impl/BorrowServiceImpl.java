package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.BorrowRequest;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.exception.BookUnavailableException;
import com.example.librarymanagement.exception.BorrowLimitException;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.BorrowRecordRepository;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.service.BorrowService;
import com.example.librarymanagement.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private static final int MAX_ACTIVE_BORROWS = 3;
    private final BorrowRecordRepository borrowRecordRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    @Transactional
    public BorrowRecord borrow(BorrowRequest request) {
        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        if (borrowRecordRepository.findByStudentIdAndReturnedFalse(student.getId()).size() >= MAX_ACTIVE_BORROWS) {
            throw new BorrowLimitException("Student has reached the borrow limit");
        }
        if (book.getAvailableCopies() <= 0) {
            throw new BookUnavailableException("Book is unavailable");
        }
        LocalDate borrowDate = LocalDate.now();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        return borrowRecordRepository.save(BorrowRecord.builder()
                .student(student)
                .book(book)
                .borrowDate(borrowDate)
                .dueDate(DateUtil.defaultDueDate(borrowDate))
                .returned(false)
                .build());
    }

    public List<BorrowRecord> findAll() {
        return borrowRecordRepository.findAll();
    }
}
