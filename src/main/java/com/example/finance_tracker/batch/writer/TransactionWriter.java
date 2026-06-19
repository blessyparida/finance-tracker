package com.example.finance_tracker.batch.writer;

import lombok.RequiredArgsConstructor;

import org.springframework.batch.item.Chunk;

import org.springframework.batch.item.ItemWriter;

import org.springframework.stereotype.Component;


import com.example.finance_tracker.entity.Transaction;

import com.example.finance_tracker.repository.TransactionRepository;

@Component

@RequiredArgsConstructor

public class TransactionWriter

implements

ItemWriter<Transaction> {

    private final
    TransactionRepository
    repository;

    @Override
public void write(

        Chunk<
                ? extends Transaction
                >
                chunk

) {

    repository.saveAll(
            chunk.getItems()
    );

}

}