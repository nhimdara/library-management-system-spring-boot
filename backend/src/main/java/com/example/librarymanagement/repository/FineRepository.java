package com.example.librarymanagement.repository;

import com.example.librarymanagement.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FineRepository extends JpaRepository<Fine, Long> {
    List<Fine> findByPaidFalse();
}
