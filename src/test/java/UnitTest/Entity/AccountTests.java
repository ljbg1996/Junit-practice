package UnitTest.Entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTests {
    @Test
    public void ConstructTest(){

        String accountNumber = "123456789";
        BigDecimal balance = new BigDecimal("1000.00");


        Account account = new Account(accountNumber, balance);

        assertThat(account).isNotNull();
        assertThat(account.getAccountNumber()).isEqualTo(accountNumber);
        assertThat(account.getBalance()).isEqualTo(balance);

    }

    @Test
    public void setterAccountNumberTest() {
        String accountNumber = "123456789";
        BigDecimal balance = new BigDecimal("1000.00");
        Account account = new Account(accountNumber, balance);

        String newAccountNumber = "1234567";
        account.setAccountNumber(newAccountNumber);
        assertThat(account.getAccountNumber()).isEqualTo(newAccountNumber);
    }


    @Test
    public void DefaultConstructTest(){

        Account account = new Account();
        assertThat(account).isNotNull();
    }

    @Test
    public void SetterTest(){
        String accountNumber = "123456789";
        BigDecimal balance = new BigDecimal("1000.00");

        Account account = new Account(accountNumber, balance);
        BigDecimal newBalance = new BigDecimal("200000");
        account.setBalance(newBalance);
        assertThat(account.getBalance()).isEqualTo(newBalance);
    }

    @Test
    public void getterIdTest() {
        Account account = new Account();
        assertThat(account.getId()).isNull();
    }



}
