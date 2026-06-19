package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public record MonthlySummaryResponse(

        String month,

        BigDecimal totalSpent

) {}