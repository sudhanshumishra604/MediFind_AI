package com.sudhanshu.medifind.auth.controller;

import com.sudhanshu.medifind.auth.dto.LoginRequest;
import com.sudhanshu.medifind.auth.dto.LoginResponse;
import com.sudhanshu.medifind.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.login(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }
}
