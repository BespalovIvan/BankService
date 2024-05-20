package com.effectiveMobile.bankService.controller;

import com.effectiveMobile.bankService.dto.SendMoneyDto;
import com.effectiveMobile.bankService.service.AccountService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/send")
    public void sendMoney(@Validated @RequestBody SendMoneyDto sendMoneyDto) {
        accountService.sendMoney(sendMoneyDto);
    }
}
