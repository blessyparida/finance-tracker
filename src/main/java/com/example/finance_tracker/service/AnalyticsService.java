package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.CategorySpendDTO;
import com.example.finance_tracker.dto.MonthlySpendDTO;
import com.example.finance_tracker.dto.TrendDTO;
import com.example.finance_tracker.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AnalyticsService {

    private final TransactionRepository repository;

    public List<MonthlySpendDTO>
    monthlySpend() {

        return repository
                .getMonthlySpend()

                .stream()

                .map(
                        row ->

                                new MonthlySpendDTO(

                                        row[0]
                                                .toString(),

                                        (
                                                java.math.BigDecimal
                                        )
                                                row[1]
                                )
                )

                .toList();
    }

    public List<CategorySpendDTO>

categorySpend() {

    return repository

            .getCategorySpend()

            .stream()

            .map(

                    row ->

                            new CategorySpendDTO(

                                    row[0]
                                            .toString(),

                                    (
                                            java.math.BigDecimal
                                    )

                                            row[1]

                            )

            )

            .toList();
}

public List<TrendDTO>

trend() {

    return repository

            .getTrend()

            .stream()

            .map(

                    row ->

                            new TrendDTO(

                                    row[0]
                                            .toString(),

                                    (
                                            java.math.BigDecimal
                                    )

                                    row[1]

                            )

            )

            .toList();
}

}