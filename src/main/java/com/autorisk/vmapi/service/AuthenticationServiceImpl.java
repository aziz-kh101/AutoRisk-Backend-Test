package com.autorisk.vmapi.service;

import org.springframework.stereotype.Service;

import com.autorisk.vmapi.dto.AuthenticationResponse;
import com.autorisk.vmapi.dto.UserDto;
import com.autorisk.vmapi.model.User;
import com.autorisk.vmapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        var jwt = jwtService.generateToken(user);
        UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .build();

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .user(userDto)
                .build();
    }
}
