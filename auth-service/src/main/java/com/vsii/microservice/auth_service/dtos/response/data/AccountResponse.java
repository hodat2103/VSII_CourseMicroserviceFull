package com.vsii.microservice.auth_service.dtos.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vsii.microservice.auth_service.entities.Account;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse extends BaseResponse{


    private Long id;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String email;

    private String password;

    @JsonProperty("role_name")
    private String roleName;


    public static AccountResponse fromAccount(Account account) {
        AccountResponse accountResponse = AccountResponse.builder()
                .id(account.getId())
                .phoneNumber(account.getPhoneNumber())
                .email(account.getEmail())
                .password(account.getPassword())
                .build();

        accountResponse.setCreatedAt(account.getCreatedAt());
        accountResponse.setUpdatedAt(account.getUpdatedAt());
        return accountResponse;
    }
}
