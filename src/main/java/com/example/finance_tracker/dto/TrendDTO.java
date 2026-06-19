package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public record TrendDTO(

        String month,

        BigDecimal total

) {}