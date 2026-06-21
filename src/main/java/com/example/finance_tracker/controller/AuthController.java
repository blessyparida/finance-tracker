package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.LoginRequest;
import com.example.finance_tracker.dto.RegisterRequest;

import com.example.finance_tracker.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(
"/auth"
)

@RequiredArgsConstructor

public class AuthController {

private final
AuthService service;


@PostMapping(
"/register"
)

public String register(

@RequestBody

RegisterRequest request

) {

return service.register(
request
);

}

@PostMapping(
"/login"
)

public String login(

@RequestBody

LoginRequest request

) {

return service.login(
request
);

}

}