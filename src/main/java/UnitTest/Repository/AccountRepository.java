package UnitTest.Repository;

import UnitTest.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a.accountNumber FROM Account a WHERE a.balance > ?1")
    List<String> findAccountsHavingBalanceGreaterThan(BigDecimal balance);

}
