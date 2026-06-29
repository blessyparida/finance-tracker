package com.example.finance_tracker.dto;
import java.math.BigDecimal;

public record MonthlySpendDTO(
String month,
BigDecimal totalSpent) {}