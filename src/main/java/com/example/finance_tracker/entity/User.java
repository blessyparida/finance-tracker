package com.example.finance_tracker.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(
            strategy =
            GenerationType.IDENTITY
    )
    private Long id;


    @Column(
            unique = true
    )
    private String email;


    private String password;


   @JsonIgnore

@OneToMany(
        mappedBy = "user"
)

private List<Transaction> transactions;

}