package com.example.login_backend.controller;

import com.example.login_backend.dto.LoginRequest;
import com.example.login_backend.dto.LoginResponse;
import com.example.login_backend.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

    String result =
            authService.login(
                    request.getEmail(),
                    request.getPassword());

    if("SUCCESS".equals(result)) {

        return new LoginResponse(
                true,
                "Login Successful");
    }

    return new LoginResponse(
            false,
            result);
    }
}