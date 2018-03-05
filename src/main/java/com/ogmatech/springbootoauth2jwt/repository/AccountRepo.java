package com.ogmatech.springbootoauth2jwt.repository;

import com.ogmatech.springbootoauth2jwt.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AccountRepo extends org.springframework.data.repository.Repository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Account save(Account account);
    int deleteAccountById(Long id);

}
