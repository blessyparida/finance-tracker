package com.example.finance_tracker.dto;

public record UploadResponse(
        String message,
        int recordsProcessed
) {
}