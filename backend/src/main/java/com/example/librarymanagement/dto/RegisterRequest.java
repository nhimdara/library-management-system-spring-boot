package com.example.librarymanagement.dto;

import com.example.librarymanagement.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(@NotBlank String username, @Email String email, @NotBlank String password, Role role) {
}
