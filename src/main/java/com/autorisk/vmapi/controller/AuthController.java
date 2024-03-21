package com.autorisk.vmapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autorisk.vmapi.dto.AuthenticationResponse;
import com.autorisk.vmapi.dto.SignInRequest;
import com.autorisk.vmapi.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        try {
            return ResponseEntity
                    .ok(authenticationService.authenticate(signInRequest.getUsername(), signInRequest.getPassword()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .notFound().build();
        }
    }

}
