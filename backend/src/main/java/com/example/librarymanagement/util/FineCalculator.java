package com.example.librarymanagement.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class FineCalculator {
    private static final BigDecimal DAILY_FINE = BigDecimal.valueOf(1.00);

    public BigDecimal calculate(LocalDate dueDate, LocalDate returnDate) {
        long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdueDays > 0 ? DAILY_FINE.multiply(BigDecimal.valueOf(overdueDays)) : BigDecimal.ZERO;
    }
}
