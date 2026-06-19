package com.example.finance_tracker.batch.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.job.builder.JobBuilder;

import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.core.repository.JobRepository;

import org.springframework.transaction.PlatformTransactionManager;

import com.example.finance_tracker.batch.reader.TransactionReader;
import com.example.finance_tracker.batch.processor.TransactionProcessor;
import com.example.finance_tracker.batch.writer.TransactionWriter;

import com.example.finance_tracker.entity.Transaction;

@Configuration

@RequiredArgsConstructor

public class BatchConfig {

    private final JobRepository repository;

    private final PlatformTransactionManager manager;

    private final TransactionReader reader;

    private final TransactionProcessor processor;

    private final TransactionWriter writer;


    @Bean
    public Step step() {

        return new StepBuilder(
                "transaction-step",
                repository
        )

        .<Transaction, Transaction>
        chunk(
                10,
                manager
        )

        .reader(reader)

        .processor(processor)

        .writer(writer)

        .build();
    }


    @Bean
    public Job job() {

        return new JobBuilder(
                "transaction-job",
                repository
        )

        .start(
                step()
        )

        .build();
    }

}