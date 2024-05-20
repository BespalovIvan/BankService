package com.effectiveMobile.bankService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SendMoneyDto {
    @Min(value = 1)
    @NotNull
    BigDecimal amount;
    @NotNull
    UUID idSender;
    @NotNull
    UUID idRecipient;
}
