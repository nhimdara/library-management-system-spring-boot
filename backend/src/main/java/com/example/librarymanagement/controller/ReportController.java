package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.ReportResponse;
import com.example.librarymanagement.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/summary")
    public ReportResponse summary() {
        return reportService.summary();
    }
}
