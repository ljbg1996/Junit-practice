package UnitTest.Service;

import UnitTest.Entity.Account;
import UnitTest.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public Account deposit(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdraw(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        int gaps = account.getBalance().compareTo(amount);
        if(gaps < 0){
            throw new RuntimeException("Balance not enough, check your account!");
        }else {
            account.setBalance(account.getBalance().subtract(amount));
        }
        return accountRepository.save(account);
    }
    @Transactional
    public Account createAccount(String accountNumber, BigDecimal initialBalance) {
        Account newAccount = new Account(accountNumber, initialBalance);
        return accountRepository.save(newAccount);
    }

    @Transactional
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Transactional
    public void deleteAccount(Long accountId){
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public List<String> getRichAccount(BigDecimal balance){
       return accountRepository.findAccountsHavingBalanceGreaterThan(balance);
    }
}
