package com.example.finance_tracker.service;

import lombok.RequiredArgsConstructor;

import org.springframework.batch.core.*;

import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class BatchService {

    private final
    JobLauncher
    launcher;

    private final
    Job
    job;


    public void start()
            throws Exception {

        launcher.run(

                job,

                new JobParametersBuilder()

                        .addLong(
                                "time",
                                System.currentTimeMillis()
                        )

                        .toJobParameters()

        );

    }

}