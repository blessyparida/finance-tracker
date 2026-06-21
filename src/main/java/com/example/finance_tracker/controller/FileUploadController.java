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
import com.example.finance_tracker.service.JWTService;

@RestController
@RequestMapping("/upload")

@RequiredArgsConstructor

public class FileUploadController {


    private final csvParser parser;

    private final TransactionService service;

    private final BatchService batchService;

    private final JWTService jwtService;

    @PostMapping

public UploadResponse upload(

@RequestParam(
"file"
)

MultipartFile file,

@RequestHeader(
"Authorization"
)

String header

)

throws Exception {

String token =

header.substring(
7
);

String email =

jwtService.extractEmail(
token
);

parser.parse(
file
);

batchService.start(
email
);

return new UploadResponse(

"Batch Import Started",

1

);

}

}