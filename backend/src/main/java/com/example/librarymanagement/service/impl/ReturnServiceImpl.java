package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.ReturnRequest;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.entity.Fine;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.BorrowRecordRepository;
import com.example.librarymanagement.repository.FineRepository;
import com.example.librarymanagement.service.ReturnService;
import com.example.librarymanagement.util.FineCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReturnServiceImpl implements ReturnService {
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final FineRepository fineRepository;
    private final FineCalculator fineCalculator;

    @Transactional
    public BorrowRecord returnBook(ReturnRequest request) {
        BorrowRecord record = borrowRecordRepository.findById(request.borrowRecordId())
                .orElseThrow(() -> new ResourceNotFoundException("Borrow record not found"));
        if (record.isReturned()) {
            throw new IllegalArgumentException("Book already returned");
        }
        LocalDate returnDate = LocalDate.now();
        record.setReturned(true);
        record.setReturnDate(returnDate);
        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        BigDecimal amount = fineCalculator.calculate(record.getDueDate(), returnDate);
        if (amount.signum() > 0) {
            fineRepository.save(Fine.builder().borrowRecord(record).amount(amount).paid(false).build());
        }
        return borrowRecordRepository.save(record);
    }
}
