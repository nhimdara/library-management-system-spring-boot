package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.StudentRequest;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> all() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student create(@Valid @RequestBody StudentRequest request) {
        return studentService.create(request);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return studentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
