package com.example.finance_tracker.batch.reader;

import com.example.finance_tracker.entity.Transaction;

import org.springframework.batch.item.support.ListItemReader;

import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TransactionReader
extends
ListItemReader<Transaction> {

    public TransactionReader(
            List<Transaction> data
    ) {

        super(
                data
        );

    }

}