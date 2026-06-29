package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.LoginRequest;
import com.example.finance_tracker.dto.RegisterRequest;
import com.example.finance_tracker.entity.User;
import com.example.finance_tracker.repository.UserRepository;
import com.example.finance_tracker.service.JWTService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JWTService jwtService;


    public String register(RegisterRequest request)
     {

        User user = User.builder()
                        .email(request.email())
                        .password(encoder.encode(request.password()))
                        .build();

        repository.save(user);

        return "Registered";
    }

    public String login(LoginRequest request) {

User user = repository.findByEmail(request.email()).orElseThrow();

if (!encoder.matches
        (request.password(),user.getPassword()

))
 {

throw new RuntimeException(
"Invalid credentials"
);

}
return jwtService.generate(
user.getEmail()
);

}

}