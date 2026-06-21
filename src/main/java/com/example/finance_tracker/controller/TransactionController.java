package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.CreateTransactionRequest;
import com.example.finance_tracker.entity.Transaction;
import com.example.finance_tracker.service.TransactionService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")

@RequiredArgsConstructor

public class TransactionController {

    private final TransactionService service;

    @PostMapping

public Transaction create(

        @Valid
        @RequestBody
        CreateTransactionRequest request,

        @RequestHeader(
                "Authorization"
        )

        String header

) {

    return service.create(

            request,

            header

    );

}

}