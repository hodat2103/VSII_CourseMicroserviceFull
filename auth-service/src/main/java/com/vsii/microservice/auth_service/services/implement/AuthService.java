package com.vsii.microservice.auth_service.services.implement;


import com.vsii.microservice.auth_service.clients.UserServiceClient;
import com.vsii.microservice.auth_service.components.JwtTokenUtils;
import com.vsii.microservice.auth_service.dtos.request.LoginRequestDTO;
import com.vsii.microservice.auth_service.dtos.request.RegisterRequest;
import com.vsii.microservice.auth_service.dtos.response.data.AccountResponse;
import com.vsii.microservice.auth_service.entities.Account;
import com.vsii.microservice.auth_service.entities.Permission;
import com.vsii.microservice.auth_service.exceptions.DataNotFoundException;
import com.vsii.microservice.auth_service.repositories.AccountRepository;
import com.vsii.microservice.auth_service.repositories.PermissionRepository;
import com.vsii.microservice.auth_service.services.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final UserServiceClient userServiceClient;
    private final JwtTokenUtils jwtTokenUtils;
    private final AccountRepository accountRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public String login(LoginRequestDTO loginRequestDTO) throws Exception {
        Optional<Account> optionalAccount = accountRepository.findByPhoneNumber(loginRequestDTO.getPhoneNumber());
        if (optionalAccount.isEmpty()) {
            throw new DataNotFoundException("Not found account");
        }
        Account existingAccount = optionalAccount.get();

        if (!existingAccount.isActive()) {
            throw new DataNotFoundException("Not found account");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getPhoneNumber(), loginRequestDTO.getPassword(), existingAccount.getAuthorities()
        );

        // Authenticate user with Spring Security
        authenticationManager.authenticate(authenticationToken);

        return jwtTokenUtils.generateToken(existingAccount);
    }

    @Override
    public AccountResponse register(RegisterRequest request) {
        return userServiceClient.save(request).getBody();
    }

    @Override
    public Map<String, List<String>> getRolesAndPermissions(String phoneNumber) {
        Account account = accountRepository.findByPhoneNumber(phoneNumber).get();
        Map<String, List<String>> rolesAndPermissions = new HashMap<>();

        List<Permission> permissions = permissionRepository.findByRoleIgnoreCase(account.getRole().getName());
        for (Permission permission : permissions) {
            rolesAndPermissions.computeIfAbsent(permission.getEndPoint(), k -> new ArrayList<>()).add(permission.getHttpMethod().name());
        }
        return rolesAndPermissions;
    }
}
