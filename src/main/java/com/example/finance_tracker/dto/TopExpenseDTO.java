package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public record TopExpenseDTO(

        String description,

        BigDecimal amount

) {}