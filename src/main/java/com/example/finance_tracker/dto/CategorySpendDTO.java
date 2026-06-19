package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public record CategorySpendDTO(

        String category,

        BigDecimal total

) {}