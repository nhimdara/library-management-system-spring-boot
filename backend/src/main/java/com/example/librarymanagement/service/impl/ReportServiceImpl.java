package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.ReportResponse;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.BorrowRecordRepository;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    public ReportResponse summary() {
        return new ReportResponse(
                bookRepository.count(),
                studentRepository.count(),
                borrowRecordRepository.countByReturnedFalse(),
                borrowRecordRepository.countByReturnedFalseAndDueDateBefore(LocalDate.now())
        );
    }
}
