package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.BorrowRequest;
import com.example.librarymanagement.entity.BorrowRecord;

import java.util.List;

public interface BorrowService {
    BorrowRecord borrow(BorrowRequest request);
    List<BorrowRecord> findAll();
}
