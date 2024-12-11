package com.vsii.microservice.auth_service.controllers;


import com.vsii.microservice.auth_service.dtos.request.*;
import com.vsii.microservice.auth_service.dtos.response.ResponseSuccess;
import com.vsii.microservice.auth_service.dtos.response.data.AccountResponse;
import com.vsii.microservice.auth_service.services.IAuthService;
import com.vsii.microservice.auth_service.services.implement.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("${api.prefix}/auth-service")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequestDTO loginRequestDTO
    ) throws Exception {

        String token = authService.login(loginRequestDTO);
        ResponseSuccess responseSuccess = new ResponseSuccess(HttpStatus.OK,"Login successfully: " + token );
        return ResponseEntity.ok(responseSuccess);

    }
    @PostMapping("/register")
    public ResponseEntity<AccountResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(@RequestParam(required = false) String name){
        log.info("Health check endpoint hit!");
        return ResponseEntity.ok("Application auth-service running. Hello admin " + name);
    }
    @GetMapping("/get-roles-permissions")
    public ResponseEntity<Map<String, List<String>>> getRolesAndPermissions(String phoneNumber){
        Map<String, List<String>> rolesAndPermissions = authService.getRolesAndPermissions(phoneNumber);
        return ResponseEntity.ok(rolesAndPermissions);
    }
}
