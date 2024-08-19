package com.filterrecipe.auth.controller;

import com.filterrecipe.auth.dto.SignUpReqDto;
import com.filterrecipe.auth.dto.UserDto;
import com.filterrecipe.auth.service.AuthService;
import com.filterrecipe.common.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse<UserDto>> signUp(@Valid @RequestBody SignUpReqDto dto) {
        UserDto response = authService.signUp(dto);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
