package com.library.service;

import com.library.dto.BorrowRequestDto;
import com.library.dto.BorrowResponseDto;
import java.util.List;

public interface BorrowService {
    BorrowResponseDto borrowBook(BorrowRequestDto request);
    BorrowResponseDto getBorrowRecordById(Long id);
    List<BorrowResponseDto> getBorrowRecordsByMember(Long memberId);
}