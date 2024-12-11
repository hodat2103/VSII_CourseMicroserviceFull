package com.vsii.microservice.auth_service.dtos.request;

import com.vsii.microservice.auth_service.entities.Role;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
