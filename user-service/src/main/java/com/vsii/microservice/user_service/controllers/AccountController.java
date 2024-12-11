package com.vsii.microservice.user_service.controllers;


import com.vsii.microservice.user_service.dtos.request.RegisterRequestDTO;
import com.vsii.microservice.user_service.dtos.response.ResponseSuccess;
import com.vsii.microservice.user_service.dtos.response.data.AccountResponse;
import com.vsii.microservice.user_service.entities.Account;
import com.vsii.microservice.user_service.exceptions.DataNotFoundException;
import com.vsii.microservice.user_service.exceptions.PermissionDenyException;
import com.vsii.microservice.user_service.services.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}user-service")
//@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;


    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Hello user. Application user-service running successfully");    }
    @GetMapping("/find-by-phone-number")
    public ResponseEntity<?> getAccount(@Pattern(regexp = "0\\d{9}") @RequestParam("phone_number") String phoneNumber) throws DataNotFoundException, GeneralSecurityException,Exception {
        AccountResponse accountResponse = accountService.getAccountById(phoneNumber);
        ResponseSuccess responseSuccess = new ResponseSuccess(HttpStatus.OK,"Retrieve account successfully", accountResponse );
        return ResponseEntity.ok(responseSuccess);
    }

}
