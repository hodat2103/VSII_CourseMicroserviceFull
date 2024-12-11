package com.vsii.microservice.user_service.services;


import com.vsii.microservice.user_service.dtos.response.data.AccountResponse;
import com.vsii.microservice.user_service.entities.Account;
import com.vsii.microservice.user_service.exceptions.DataNotFoundException;
import com.vsii.microservice.user_service.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    private static final long ROLE_DEFAULT = 2;
    /**
     * Method de dang kt tai khoan cho nguoi dung
     *
     * @Param {@link RegisterRequestDTO} da duoc validate
     * @Return tra ve object Account tai khoan moi duoc tao
     * @throws PermissionDenyException khi khong phu hop voi quyen admin trong role database
     * @throws DataNotFoundException khi khong tim thay role_name theo role_id
     * @throws DataIntegrityViolationException khi khong ton tai sdt trong database
     */



//    @Override
//    public UserDetails loadUserByUsername(String phoneNumber) {
//        return accountRepository.findByPhoneNumber(phoneNumber)
//                .orElseThrow(() -> new UsernameNotFoundException("Account not found"));
//    }

    /**
     * Method tim account theo id
     * @param phoneNumber cua account
     * @return tra ve 1 object account theo id
     * @throws DataNotFoundException khi khong tim thay account theo id yeu cau
     */
    @Override
    public AccountResponse getAccountById(String phoneNumber) throws GeneralSecurityException,IllegalArgumentException, InvalidKeyException, Exception {
        Account account =  accountRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new DataNotFoundException("Account not found"));
        return AccountResponse.builder()
                .id(account.getId())
                .phoneNumber(account.getPhoneNumber())
                .email(account.getEmail())
                .password(account.getPassword())
                .build();
    }

}
