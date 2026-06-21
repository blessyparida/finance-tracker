package com.example.finance_tracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="transactions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Transaction {

    @Id
    @GeneratedValue(
            strategy =
            GenerationType.IDENTITY
    )
    private Long id;


    private String description;


    private BigDecimal amount;


    private LocalDate transactionDate;


    @Enumerated(
            EnumType.STRING
    )
    private Category category;


    @ManyToOne

    @JoinColumn(
            name = "user_id"
    )

    private User user;

}