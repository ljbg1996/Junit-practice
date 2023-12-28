package com.example.unittest.practice.Service;

import com.example.unittest.practice.Entity.Account;
import com.example.unittest.practice.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void deposit(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        int gaps = account.getBalance().compareTo(amount);
        if(gaps < 0){
            throw new RuntimeException("Balance not enough, check your account!");
        }else {
            account.setBalance(account.getBalance().subtract(amount));
        }

        accountRepository.save(account);
    }
    @Transactional
    public Account createAccount(String accountNumber, BigDecimal initialBalance) {
        Account newAccount = new Account(accountNumber, initialBalance);
        return accountRepository.save(newAccount);
    }

}
