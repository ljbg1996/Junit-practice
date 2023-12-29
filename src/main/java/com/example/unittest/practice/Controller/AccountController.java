package com.example.unittest.practice.Controller;

import com.example.unittest.practice.Entity.Account;
import com.example.unittest.practice.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}/deposit")
    public Account deposit(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        return accountService.deposit(accountId, amount);
    }

    @PostMapping("/{accountId}/withdraw")
    public Account withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        return accountService.withdraw(accountId, amount);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestParam String accountNumber, @RequestParam BigDecimal initialBalance) {
        return accountService.createAccount(accountNumber, initialBalance);
    }

    @GetMapping("/allAccounts")
    public List<Account> findAllAccount() {
        return accountService.getAllAccount();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
