package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BorrowRequest;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.service.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @GetMapping
    public List<BorrowRecord> all() {
        return borrowService.findAll();
    }

    @PostMapping
    public BorrowRecord borrow(@Valid @RequestBody BorrowRequest request) {
        return borrowService.borrow(request);
    }
}
