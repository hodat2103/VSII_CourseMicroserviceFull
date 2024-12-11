package com.vsii.microservice.auth_service.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class RegisterRequest {

    @NotBlank(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    @Pattern(regexp = "0\\d{9}", message = "Phone number must start with 0 and contain 10 digits")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
    private String password;

    @NotBlank(message = "Retype Password cannot be empty")
    @Size(min = 6, max = 255, message = "Retype password must be between 6 and 255 characters")
    @JsonProperty("retype_password")
    private String retypePassword;

    @NotBlank(message = "Email is required")
//    @Size(min = 11, max = 255, message = "Username must be between 11 and 255 characters")
    @Email
    private String email;

    @JsonProperty("role_id")
    @Min(value = 0, message = "Role Id must be positive integer")
    private Long roleId;
}
