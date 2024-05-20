package com.effectiveMobile.bankService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private UUID id;
    @NotNull
    @Min(value = 0,message = "the amount cannot be negative")
    @Column(name = "sum")
    private BigDecimal sum;

    public BankAccount(BigDecimal sum) {
        this.sum = sum;
    }
}
