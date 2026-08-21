package com.library.controller;

import com.library.dto.BorrowRequestDto;
import com.library.dto.BorrowResponseDto;
import com.library.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<BorrowResponseDto> borrowBook(@Valid @RequestBody BorrowRequestDto request) {
        BorrowResponseDto response = borrowService.borrowBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowResponseDto> getBorrowRecord(@PathVariable Long id) {
        return ResponseEntity.ok(borrowService.getBorrowRecordById(id));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BorrowResponseDto>> getBorrowRecordsByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(borrowService.getBorrowRecordsByMember(memberId));
    }
}