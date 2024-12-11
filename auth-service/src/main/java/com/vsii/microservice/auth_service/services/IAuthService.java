package com.vsii.microservice.auth_service.services;

import com.vsii.microservice.auth_service.dtos.request.LoginRequest;
import com.vsii.microservice.auth_service.dtos.request.LoginRequestDTO;
import com.vsii.microservice.auth_service.dtos.request.RegisterRequest;
import com.vsii.microservice.auth_service.dtos.request.TokenDto;
import com.vsii.microservice.auth_service.dtos.response.data.AccountResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IAuthService {
    /**
     * Method dang nhap tai khoan nguoi dung

     * @return token moi tao duoc
//     * @throws DataNotFoundException khi khong tim thay tai khoan trong DB hoac tai khoan nay khong hoat dong nua
     */
    public String login(LoginRequestDTO loginRequestDTO) throws Exception;


    /**
     * Method: Dang ky 1 tai khoan nguoi dung
     *
     * @param request {@link RegisterRequest} truyen vao 1 request DTO chua thong tin cua mot tai khona nguoi dung de register
     * @return tra ve thong tin tai khoan vua dang ky
     */
    public AccountResponse register(RegisterRequest request);
    public Map<String, List<String>> getRolesAndPermissions(String phoneNumber);

}
