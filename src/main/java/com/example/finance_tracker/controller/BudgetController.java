package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.BudgetResponse;

import com.example.finance_tracker.service.BudgetService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController

@RequestMapping("/budget")

@RequiredArgsConstructor

public class BudgetController {

    private final BudgetService service;

    @GetMapping

    public BudgetResponse
    check(@RequestParam BigDecimal budget
    ) {

        return service.evaluate(budget);
    }

}