package com.example.finance_tracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.example.finance_tracker.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;


public record CreateTransactionRequest(

        @NotBlank
        String description,

        @NotNull
        BigDecimal amount,

        @NotNull
        LocalDate transactionDate,

        Category category
) {}
