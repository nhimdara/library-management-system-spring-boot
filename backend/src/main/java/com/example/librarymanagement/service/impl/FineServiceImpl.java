package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.entity.Fine;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.repository.FineRepository;
import com.example.librarymanagement.service.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FineServiceImpl implements FineService {
    private final FineRepository fineRepository;

    public List<Fine> findAll() {
        return fineRepository.findAll();
    }

    public List<Fine> unpaid() {
        return fineRepository.findByPaidFalse();
    }

    public Fine markPaid(Long id) {
        Fine fine = fineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fine not found"));
        fine.setPaid(true);
        return fineRepository.save(fine);
    }
}
