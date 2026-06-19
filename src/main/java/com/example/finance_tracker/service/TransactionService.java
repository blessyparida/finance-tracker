package com.example.finance_tracker.service;

import com.example.finance_tracker.dto.CreateTransactionRequest;
import com.example.finance_tracker.entity.Transaction;
import com.example.finance_tracker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class TransactionService {

    private final TransactionRepository repository;

    public Transaction create(
            CreateTransactionRequest request
    ) {

        Transaction transaction =
                Transaction.builder()
                        .description(request.description())
                        .amount(request.amount())
                        .transactionDate(
                                request.transactionDate()
                        )
                        .category(request.category())
                        .build();

        return repository.save(transaction);
    }
    public int saveAll(
        List<Transaction> transactions
) {

    repository.saveAll(
            transactions
    );

    return transactions.size();
}

}
