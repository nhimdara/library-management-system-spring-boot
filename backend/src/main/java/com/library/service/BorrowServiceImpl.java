package com.library.service;

import com.library.dto.BorrowRequestDto;
import com.library.dto.BorrowResponseDto;
import com.library.exception.BookNotAvailableException;
import com.library.exception.ResourceNotFoundException;
import com.library.model.Book;
import com.library.model.Member;
import com.library.model.BorrowRecord;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRecordRepository;
import com.library.repository.MemberRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    private static final int LOAN_PERIOD_DAYS = 14;

    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowServiceImpl(
            BorrowRecordRepository borrowRecordRepository,
            BookRepository bookRepository,
            MemberRepository memberRepository) {

        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public BorrowResponseDto borrowBook(BorrowRequestDto request) {

        // 1. Verify book exists
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Book not found with id: "
                                        + request.getBookId()
                        )
                );

        // 2. Check book availability
        if (book.getAvailableQuantity() <= 0) {

            throw new BookNotAvailableException(
                    "Book '" + book.getTitle()
                            + "' is not available right now"
            );
        }

        // 3. Verify member exists
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Member not found with id: "
                                        + request.getMemberId()
                        )
                );

        // 4. Create borrow record
        BorrowRecord record = new BorrowRecord();

        record.setBook(book);
        record.setMember(member);

        LocalDate borrowDate = LocalDate.now();

        record.setBorrowDate(borrowDate);
        record.setDueDate(
                borrowDate.plusDays(LOAN_PERIOD_DAYS)
        );

        record.setStatus(
                BorrowRecord.BorrowStatus.BORROWED
        );

        // 5. Update available book quantity
        book.setAvailableQuantity(
                book.getAvailableQuantity() - 1
        );

        bookRepository.save(book);

        // 6. Save borrow record
        BorrowRecord saved =
                borrowRecordRepository.save(record);

        // 7. Return response
        return BorrowResponseDto.fromEntity(saved);
    }

    @Override
    public BorrowResponseDto getBorrowRecordById(Long id) {

        BorrowRecord record =
                borrowRecordRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Borrow record not found with id: "
                                                + id
                                )
                        );

        return BorrowResponseDto.fromEntity(record);
    }

    @Override
    public List<BorrowResponseDto> getBorrowRecordsByMember(
            Long memberId) {

        // Verify member exists
        memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Member not found with id: "
                                        + memberId
                        )
                );

        return borrowRecordRepository
                .findByMemberId(memberId)
                .stream()
                .map(BorrowResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}