package com.example.finance_tracker.service;

import com.example.finance_tracker.entity.Category;

import org.springframework.stereotype.Service;

@Service
public class CategorizationService {

    public Category categorize(
            String description
    ) {

        description =
                description
                        .toLowerCase();

        if (
                description.contains(
                        "swiggy"
                )
                ||
                description.contains(
                        "zomato"
                )
        )
            return Category.FOOD;


        if (
                description.contains(
                        "rent"
                )
        )
            return Category.RENT;


        if (
                description.contains(
                        "emi"
                )
        )
            return Category.EMI;


        if (
                description.contains(
                        "netflix"
                )
        )
            return Category.ENTERTAINMENT;


        return Category.OTHER;
    }
}