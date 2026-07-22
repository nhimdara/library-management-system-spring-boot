package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "success");
        response.put("message", "Library Management API is running");
        response.put("port", 8080);
        return response;
    }
}
