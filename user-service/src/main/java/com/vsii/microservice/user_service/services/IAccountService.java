package com.vsii.microservice.user_service.services;


import com.vsii.microservice.user_service.dtos.response.data.AccountResponse;
import com.vsii.microservice.user_service.exceptions.DataNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;

/**
 * IService nay chua cac method public voi muc dich chua cac method de phan chia cac cong viec lien quan den tai khoan nguoi dung
 */

@Service
public interface IAccountService {


//    public UserDetails loadUserByPhoneNumber(String username);
    /**
     * Method tim account theo id
     * @param phoneNumber cua account
     * @return tra ve 1 object account theo id
     * @throws DataNotFoundException khi khong tim thay account theo id yeu cau
     */
    public AccountResponse getAccountById(String phoneNumber) throws DataNotFoundException, GeneralSecurityException, Exception;
}
