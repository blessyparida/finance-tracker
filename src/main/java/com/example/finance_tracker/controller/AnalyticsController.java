package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.CategorySpendDTO;
import com.example.finance_tracker.dto.MonthlySpendDTO;
import com.example.finance_tracker.dto.TrendDTO;
import com.example.finance_tracker.service.AnalyticsService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(
"/analytics"
)

@RequiredArgsConstructor

public class AnalyticsController {

    private final
    AnalyticsService service;


    @GetMapping(
"/monthly"
)

    public List<
            MonthlySpendDTO
            >

    get() {

        return
                service
                        .monthlySpend();
    }


    @GetMapping(
"/category"
)

public List<
CategorySpendDTO
>

category() {

    return

            service

                    .categorySpend();
}

@GetMapping(
"/trend"
)

public List<
TrendDTO
>

trend() {

    return

            service

                    .trend();
}

}