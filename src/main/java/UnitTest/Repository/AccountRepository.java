package UnitTest.Repository;

import UnitTest.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 使用方法命名约定
    //List<Account> findByBalanceGreaterThan(BigDecimal balance);

    // 或者使用@Query注解定义自定义查询
    @Query("SELECT a.accountNumber FROM Account a WHERE a.balance > ?1")
    List<String> findAccountsHavingBalanceGreaterThan(BigDecimal balance);

}
