package com.example.librarymanagement.dto;

import jakarta.validation.constraints.NotNull;

public record ReturnRequest(@NotNull Long borrowRecordId) {
}
