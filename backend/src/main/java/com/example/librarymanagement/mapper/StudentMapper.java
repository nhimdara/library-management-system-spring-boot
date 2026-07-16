package com.example.librarymanagement.mapper;

import com.example.librarymanagement.dto.StudentRequest;
import com.example.librarymanagement.entity.Student;

public final class StudentMapper {
    private StudentMapper() {
    }

    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setStudentCode(request.studentCode());
        student.setFullName(request.fullName());
        student.setEmail(request.email());
        student.setPhone(request.phone());
        student.setDepartment(request.department());
        return student;
    }
}
