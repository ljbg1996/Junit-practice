package UnitTest.Controller;

import UnitTest.Entity.Account;
import UnitTest.Service.AccountService;
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

    @PostMapping("/richAccounts")
    public List<String> getRichAccount(@RequestParam BigDecimal conditionBalance) {
        return accountService.getRichAccount(conditionBalance);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
