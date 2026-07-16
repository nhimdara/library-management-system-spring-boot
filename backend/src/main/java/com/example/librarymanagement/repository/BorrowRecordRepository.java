package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    long countByReturnedFalse();
    long countByReturnedFalseAndDueDateBefore(LocalDate date);
    List<BorrowRecord> findByStudentIdAndReturnedFalse(Long studentId);
}
