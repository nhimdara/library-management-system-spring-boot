package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.ReturnRequest;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.service.ReturnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/returns")
@RequiredArgsConstructor
public class ReturnController {
    private final ReturnService returnService;

    @PostMapping
    public BorrowRecord returnBook(@Valid @RequestBody ReturnRequest request) {
        return returnService.returnBook(request);
    }
}
