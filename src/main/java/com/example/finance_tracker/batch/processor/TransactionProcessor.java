package com.example.finance_tracker.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import org.springframework.stereotype.Component;

import com.example.finance_tracker.entity.Transaction;


@Component


public class TransactionProcessor

implements

ItemProcessor<
Transaction,
Transaction
> {

    @Override

    public Transaction process(
            Transaction item
    ) {

        if (
                item.getAmount()
                        .doubleValue()
                        < 0
        ) {

            item.setAmount(
                    item
                            .getAmount()
                            .abs()
            );

        }

        return item;

    }

}