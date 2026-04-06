package com.example.zenVault.repository;

import com.example.zenVault.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

    Optional<AccountEntity> findByAccountNumber(String accountNumber);

    AccountEntity findByAccountNumberAndUserEntityId(String accountNumber, Long id);

}
