package com.example.unittest.practice.Repository;

import com.example.unittest.practice.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // 可以添加自定义的查询方法
}
