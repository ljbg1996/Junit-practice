package com.example.unittest.practice.Controller;

import com.example.unittest.practice.Entity.Account;
import com.example.unittest.practice.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}/deposit")
    public void deposit(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public void withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        accountService.withdraw(accountId, amount);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestParam String accountNumber, @RequestParam BigDecimal initialBalance) {
        return accountService.createAccount(accountNumber, initialBalance);
    }

}
