package com.example.finance_tracker.dto;

import java.math.BigDecimal;

public record BudgetResponse(
BigDecimal budget,
BigDecimal spent,
BigDecimal remaining,
String alert) {}