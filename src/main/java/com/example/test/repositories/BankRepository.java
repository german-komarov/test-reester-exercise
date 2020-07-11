package com.example.test.repositories;

import com.example.test.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank,Long> {
    Optional<Bank> findBankByName(String name);
}
