package com.example.librarymanagement;

import com.example.librarymanagement.util.FineCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class FineServiceTest {
    private final FineCalculator calculator = new FineCalculator();

    @Test
    void calculatesFineForOverdueReturn() {
        BigDecimal fine = calculator.calculate(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 4));
        assertThat(fine).isEqualByComparingTo("3.00");
    }

    @Test
    void returnsZeroWhenNotOverdue() {
        BigDecimal fine = calculator.calculate(LocalDate.of(2026, 1, 4), LocalDate.of(2026, 1, 1));
        assertThat(fine).isZero();
    }
}
