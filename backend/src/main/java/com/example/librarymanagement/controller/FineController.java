package com.example.librarymanagement.controller;

import com.example.librarymanagement.entity.Fine;
import com.example.librarymanagement.service.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fines")
@RequiredArgsConstructor
public class FineController {
    private final FineService fineService;

    @GetMapping
    public List<Fine> all(@RequestParam(defaultValue = "false") boolean unpaidOnly) {
        return unpaidOnly ? fineService.unpaid() : fineService.findAll();
    }

    @PostMapping("/{id}/pay")
    public Fine pay(@PathVariable Long id) {
        return fineService.markPaid(id);
    }
}
