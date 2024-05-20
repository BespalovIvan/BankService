package com.effectiveMobile.bankService.repository;

import com.effectiveMobile.bankService.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface AccountRepo extends JpaRepository<BankAccount, UUID> {
    @Modifying
    @Query(value = "BEGIN; \n" +
            "UPDATE accounts SET sum = sum - ?1 WHERE account_id = (SELECT account_id FROM users WHERE user_id = ?2); \n" +
            "UPDATE accounts SET sum = sum + ?1 WHERE account_id = (SELECT account_id FROM users WHERE user_id = ?3); \n" +
            "COMMIT;",nativeQuery = true)
    void sendMoney(@Param("amount") BigDecimal amount, @Param("id") UUID idSender,UUID idRecipient);
}
