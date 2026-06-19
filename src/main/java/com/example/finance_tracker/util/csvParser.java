package com.example.finance_tracker.util;


import com.example.finance_tracker.entity.Transaction;
import com.opencsv.CSVReader;

import org.springframework.stereotype.Component;

import java.io.InputStreamReader;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;



import com.example.finance_tracker.service.CategorizationService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class csvParser {

    private final CategorizationService categorizer;

    public List<Transaction> parse(
            MultipartFile file
    ) throws Exception {

        List<Transaction> transactions =
                new ArrayList<>();

        CSVReader reader =
                new CSVReader(
                        new InputStreamReader(
                                file.getInputStream()
                        )
                );

        reader.readNext();

        String[] row;

        while (
                (row = reader.readNext())
                        != null
        ) {

            transactions.add(

                    Transaction.builder()

                            .transactionDate(
                                    LocalDate.parse(
                                            row[0]
                                    )
                            )

                            .description(
                                    row[1]
                            )

                            .amount(
                                    new BigDecimal(
                                            row[2]
                                    )
                            )

                            .category(
    categorizer.categorize(
        row[1]
    )
)
                            .build()
            );
        }

        return transactions;
    }
}