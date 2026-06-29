package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.CategorySpendDTO;
import com.example.finance_tracker.dto.MonthlySpendDTO;
import com.example.finance_tracker.dto.TopExpenseDTO;
import com.example.finance_tracker.dto.TrendDTO;

import com.example.finance_tracker.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import com.example.finance_tracker.service.JWTService;

@Service
@RequiredArgsConstructor

public class AnalyticsService {

    private final TransactionRepository repository;

    private final JWTService jwtService;


    public List<MonthlySpendDTO> monthlySpend(String header)
     {

        String token = header.substring(7); //removes bearer

        String email = jwtService.extractEmail(token);

        return repository.getMonthlySpendByUser(email)
                        .stream()
                        .map(row -> new MonthlySpendDTO(row[0].toString(),(BigDecimal)row[1]))
                

                .toList();
    }


    public List<CategorySpendDTO> categorySpend() {

        return repository
                .getCategorySpend()
                .stream()
                .map(row -> new CategorySpendDTO(row[0].toString(),(BigDecimal)row[1]))
                .toList();
    }


    public List<TrendDTO> trend() {

        return repository
                .getTrend()
                .stream()
                .map(
                        row ->

                                new TrendDTO(

                                        row[0].toString(),

                                        (BigDecimal)
                                                row[1]

                                )
                )
                .toList();
    }


    public List<TopExpenseDTO> topExpenses() {

        return repository
                .topExpenses()
                .stream()
                .map(
                        row ->

                                new TopExpenseDTO(

                                        row[0].toString(),

                                        (BigDecimal)
                                                row[1]

                                )
                )
                .toList();
    }

}