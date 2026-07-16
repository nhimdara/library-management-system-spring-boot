package com.example.librarymanagement.service;

import com.example.librarymanagement.entity.Fine;

import java.util.List;

public interface FineService {
    List<Fine> findAll();
    List<Fine> unpaid();
    Fine markPaid(Long id);
}
