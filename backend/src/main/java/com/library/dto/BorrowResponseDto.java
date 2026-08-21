package com.library.dto;

import com.library.model.BorrowRecord;
import java.time.LocalDate;

public class BorrowResponseDto {

    private Long id;
    private Long bookId;
    private String bookTitle;
    private Long memberId;
    private String memberName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;

    public static BorrowResponseDto fromEntity(BorrowRecord record) {
        BorrowResponseDto dto = new BorrowResponseDto();
        dto.id = record.getId();
        dto.bookId = record.getBook().getId();
        dto.bookTitle = record.getBook().getTitle();
        dto.memberId = record.getMember().getId();
        dto.memberName = record.getMember().getName();
        dto.borrowDate = record.getBorrowDate();
        dto.dueDate = record.getDueDate();
        dto.returnDate = record.getReturnDate();
        dto.status = record.getStatus().name();
        return dto;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }
    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}