package com.effectiveMobile.bankService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "account_id")
    private BankAccount account;
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
    @Column(name = "login")
    @NotEmpty
    private String login;
    @Column(name = "password")
    @NotEmpty
    private String password;

    public User(BankAccount account, Set<Long> phoneNumber, Set<String> email, String firstName, String lastName,
                LocalDate birthday, String login, String password) {
        this.account = account;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
    }
}
