package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.StudentRequest;
import com.example.librarymanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    Student create(StudentRequest request);
    Student update(Long id, StudentRequest request);
    void delete(Long id);
}
