package com.example.librarymanagement.mapper;

import com.example.librarymanagement.entity.BorrowRecord;

import java.util.Map;

public final class BorrowMapper {
    private BorrowMapper() {
    }

    public static Map<String, Object> toSummary(BorrowRecord record) {
        return Map.of(
                "id", record.getId(),
                "student", record.getStudent().getFullName(),
                "book", record.getBook().getTitle(),
                "dueDate", record.getDueDate(),
                "returned", record.isReturned()
        );
    }
}
