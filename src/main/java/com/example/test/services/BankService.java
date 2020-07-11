package com.example.test.services;

import com.example.test.entities.Bank;
import com.example.test.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public List<Bank> getAllBanks()
    {
        return bankRepository.findAll();
    }

    public Bank getBankById(Long id)
    {
        Optional<Bank> bank=bankRepository.findById(id);
        return bank.orElse(null);
    }


    public void deleteBankById(Long id)
    {
        bankRepository.deleteById(id);
    }

    public void saveBank(Bank bank)
    {
        bankRepository.save(bank);
    }

    public Bank getBankByName(String name)
    {
        Optional<Bank> bank=bankRepository.findBankByName(name);
        return bank.orElse(null);
    }


}
