package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.AuthResponse;
import com.example.librarymanagement.dto.LoginRequest;
import com.example.librarymanagement.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
