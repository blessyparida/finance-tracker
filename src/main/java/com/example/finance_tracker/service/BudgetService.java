package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.BudgetResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import com.example.finance_tracker.repository.*;

@Service
@RequiredArgsConstructor

public class BudgetService {

    private final
    TransactionRepository repository;

    public BudgetResponse
    evaluate(
            BigDecimal budget
    ) {

        BigDecimal spent =
                repository
                        .getCurrentMonthSpend();

        BigDecimal remaining =
                budget.subtract(
                        spent
                );

        String alert =
                remaining.signum()
                        < 0

                        ?

                        "Budget Exceeded"

                        :

                        "Within Budget";


        return new BudgetResponse(

                budget,

                spent,

                remaining,

                alert
        );

    }

}