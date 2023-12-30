package UnitTest.Service;

import UnitTest.Entity.Account;
import UnitTest.Repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class AccountServiceTests {
    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    private List<Account> mockAccounts;
    private Account account1;

    private Account account2;
    @BeforeEach
    void setUp(){
        //Given
        account1 = new Account("Ada",new BigDecimal("100000"));
        account2 = new Account("Jie",new BigDecimal("200000"));
        mockAccounts = Arrays.asList(account1, account2);
    }

    @Test
    public void getAllAccountsTest() {

        //mock the behavior of the accountRepository.findAll() method
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        //when
        List<Account> allAccounts = accountService.getAllAccount();

        //then
        assertThat(allAccounts.size()).isEqualTo(2);
        assertThat(allAccounts).contains(account1,account2);
    }

    @Test
    public void deleteAccountTest(){
        //Given
        Long id = 1L;

        // When
        accountService.deleteAccount(id);

        // Then
        verify(accountRepository).deleteById(id);
    }

    @Test
    public void depositTest(){
        Long accountId = 1L;
        BigDecimal initialBalance = new BigDecimal("1000");
        BigDecimal depositAmount = new BigDecimal("500");
        Account mockAccount = new Account();
        mockAccount.setId(accountId);
        mockAccount.setBalance(initialBalance);

        // 模拟findById方法的行为
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(mockAccount));

        // 模拟save方法的行为
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // 执行测试的方法
        Account updatedAccount = accountService.deposit(accountId, depositAmount);

        // 验证findById和save方法被正确调用
        verify(accountRepository).findById(accountId);
        verify(accountRepository).save(mockAccount);

        // 断言结果
        assertThat(updatedAccount.getBalance()).isEqualByComparingTo(initialBalance.add(depositAmount));
    }
}
