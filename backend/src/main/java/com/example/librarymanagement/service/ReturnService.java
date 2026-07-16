package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.ReturnRequest;
import com.example.librarymanagement.entity.BorrowRecord;

public interface ReturnService {
    BorrowRecord returnBook(ReturnRequest request);
}
