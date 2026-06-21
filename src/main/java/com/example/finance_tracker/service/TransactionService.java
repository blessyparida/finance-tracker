package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.CreateTransactionRequest;
import com.example.finance_tracker.entity.Transaction;
import com.example.finance_tracker.entity.User;
import com.example.finance_tracker.repository.TransactionRepository;
import com.example.finance_tracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TransactionService {

    private final TransactionRepository repository;

    private final UserRepository userRepository;

private final JWTService jwtService;

    public Transaction create(

CreateTransactionRequest request,

String header

) {

String token =

header.substring(
7
);

String email =

jwtService.extractEmail(
token
);

User user =

userRepository

.findByEmail(
email
)

.orElseThrow();

Transaction transaction =

Transaction
.builder()

.description(
request.description()
)

.amount(
request.amount()
)

.transactionDate(
request.transactionDate()
)

.category(
request.category()
)

.user(
user
)

.build();

return repository.save(
transaction
);

}

}
