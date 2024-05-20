package com.effectiveMobile.bankService.service.Impl;

import com.effectiveMobile.bankService.dto.NewUserDto;
import com.effectiveMobile.bankService.entity.BankAccount;
import com.effectiveMobile.bankService.entity.User;
import com.effectiveMobile.bankService.repository.UserRepo;
import com.effectiveMobile.bankService.service.AccountService;
import com.effectiveMobile.bankService.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final AccountService accountService;

    public UserServiceImpl(UserRepo userRepo, AccountServiceImpl accountService) {
        this.userRepo = userRepo;
        this.accountService = accountService;
    }

    @Override
    public void addUser(NewUserDto userDto) {
        UUID accountId = accountService.addAccount(userDto.getSum());
        User user = new User(new BankAccount(accountId, userDto.getSum()),
                userDto.getPhoneNumber(), userDto.getEmail(), userDto.getFirstName()
                , userDto.getLastName(), userDto.getBirthday(),userDto.getLogin(),userDto.getPassword());
        userRepo.save(user);
    }
}
