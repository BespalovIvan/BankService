package com.effectiveMobile.bankService.controller;

import com.effectiveMobile.bankService.dto.NewUserDto;
import com.effectiveMobile.bankService.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@Validated @RequestBody NewUserDto userDto) {
        userService.addUser(userDto);
    }
}
