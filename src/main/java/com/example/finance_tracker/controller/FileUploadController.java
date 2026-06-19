package com.example.finance_tracker.controller;

import com.example.finance_tracker.dto.UploadResponse;

import com.example.finance_tracker.service.TransactionService;

import com.example.finance_tracker.util.csvParser;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import com.example.finance_tracker.entity.Transaction;

import com.example.finance_tracker.service.BatchService;

@RestController
@RequestMapping("/upload")

@RequiredArgsConstructor

public class FileUploadController {


    private final csvParser parser;

    private final TransactionService service;

    private final BatchService batchService;

    @PostMapping

public UploadResponse upload(
        @RequestParam("file")
        MultipartFile file
)

throws Exception {

    List<Transaction> data =
            parser.parse(file);

    service.saveAll(data);

    batchService.start();

    return new UploadResponse(
            "Batch Import Started",
            data.size()
    );

}

}