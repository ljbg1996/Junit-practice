package UnitTest.Repository;


import UnitTest.Entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        Account account1 = new Account("12345", new BigDecimal("5000"));
        Account account2 = new Account("67890", new BigDecimal("10000"));
        accountRepository.save(account1);
        accountRepository.save(account2);
    }

    @Test
    public void findAccountsHavingBalanceGreaterThanTest(){
        List<String> accountList = accountRepository.findAccountsHavingBalanceGreaterThan(new BigDecimal("5000"));
        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(1);
        assertThat(accountList.contains("67890")).isTrue();
    }
}
