package com.example.librarymanagement.util;

import com.example.librarymanagement.dto.ReportResponse;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
    public String toSummary(ReportResponse report) {
        return "Books: %d, Students: %d, Active borrows: %d, Overdue: %d"
                .formatted(report.totalBooks(), report.totalStudents(), report.activeBorrows(), report.overdueBorrows());
    }
}
