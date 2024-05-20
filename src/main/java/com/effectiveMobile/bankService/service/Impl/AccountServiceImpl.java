package com.effectiveMobile.bankService.service.Impl;

import com.effectiveMobile.bankService.dto.SendMoneyDto;
import com.effectiveMobile.bankService.entity.BankAccount;
import com.effectiveMobile.bankService.entity.User;
import com.effectiveMobile.bankService.exception.NegativeAmountException;
import com.effectiveMobile.bankService.repository.AccountRepo;
import com.effectiveMobile.bankService.repository.UserRepo;
import com.effectiveMobile.bankService.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;

    public AccountServiceImpl(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @Override
    public UUID addAccount(BigDecimal initSum) {
        BankAccount account = accountRepo.save(new BankAccount(initSum));
        return account.getId();
    }

    @Transactional
    @Override
    public void sendMoney(SendMoneyDto sendMoneyDto) {
        Optional<User> optionalBankAccount = userRepo.findById(sendMoneyDto.getIdSender());
        if (optionalBankAccount.isPresent()) {
            if (optionalBankAccount.get().getAccount().getSum().compareTo(sendMoneyDto.getAmount()) < 0) {
                throw new NegativeAmountException("the amount cannot be negative");
            }
        }
        accountRepo.sendMoney(sendMoneyDto.getAmount(), sendMoneyDto.getIdSender(), sendMoneyDto.getIdRecipient());
    }
}
