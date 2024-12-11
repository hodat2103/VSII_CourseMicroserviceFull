package com.vsii.microservice.auth_service.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequest {
    @JsonProperty("phone_number")
    private String phoneNumber;

    private String password;
}
