package com.example.librarymanagement.util;

import java.time.LocalDate;

public final class DateUtil {
    private DateUtil() {
    }

    public static LocalDate defaultDueDate(LocalDate borrowDate) {
        return borrowDate.plusDays(14);
    }
}
