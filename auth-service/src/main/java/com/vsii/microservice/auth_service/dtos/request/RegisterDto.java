package com.vsii.microservice.auth_service.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {
    private String id;
    private String phoneNumber;
    private String email;
    private String password;
}
