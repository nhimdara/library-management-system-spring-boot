package com.example.librarymanagement.dto;

public record ReportResponse(long totalBooks, long totalStudents, long activeBorrows, long overdueBorrows) {
}
