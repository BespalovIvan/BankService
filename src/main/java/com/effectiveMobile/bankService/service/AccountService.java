package com.effectiveMobile.bankService.service;

import com.effectiveMobile.bankService.dto.SendMoneyDto;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {
    UUID addAccount(BigDecimal initSum);

    void sendMoney(SendMoneyDto sendMoneyDto);
}

