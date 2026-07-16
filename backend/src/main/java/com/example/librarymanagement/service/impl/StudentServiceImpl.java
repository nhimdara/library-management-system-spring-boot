package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.dto.StudentRequest;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student create(StudentRequest request) {
        if (studentRepository.existsByStudentCode(request.studentCode())) {
            throw new IllegalArgumentException("Student code already exists");
        }
        return studentRepository.save(apply(new Student(), request));
    }

    public Student update(Long id, StudentRequest request) {
        return studentRepository.save(apply(findById(id), request));
    }

    public void delete(Long id) {
        studentRepository.delete(findById(id));
    }

    private Student apply(Student student, StudentRequest request) {
        student.setStudentCode(request.studentCode());
        student.setFullName(request.fullName());
        student.setEmail(request.email());
        student.setPhone(request.phone());
        student.setDepartment(request.department());
        return student;
    }
}
