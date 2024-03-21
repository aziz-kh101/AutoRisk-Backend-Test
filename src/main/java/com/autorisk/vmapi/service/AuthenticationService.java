package com.autorisk.vmapi.service;

import com.autorisk.vmapi.dto.AuthenticationResponse;

public interface AuthenticationService {
    public AuthenticationResponse authenticate(String username, String password);
}
