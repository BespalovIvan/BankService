package com.effectiveMobile.bankService.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class NewUserDto {
    @Column(name = "phone_number")
    @Size(min = 1)
    private Set<Long> phoneNumber;
    @Column(name = "email")
    @Size(min = 1)
    private Set<String> email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @NotNull
    @Min(1)
    @Column(name = "sum")
    private BigDecimal sum;
    @Column(name = "login")
    @NotEmpty
    private String login;
    @Column(name = "password")
    @NotEmpty
    private String password;
}
