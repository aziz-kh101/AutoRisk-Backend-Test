package com.autorisk.vmapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignInRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
