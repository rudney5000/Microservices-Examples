package com.dedytech.accountservice.service;

import com.dedytech.accountservice.entity.Account;
import com.dedytech.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    public List<Account> findAll() {
        return accountRepository.findAll();
    };

    public Account get(String id) {
        return accountRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    public Account save(Account account) {

        return accountRepository.save(account);
    }

    public Account update(String id, Account account)
    {
        Assert.isNull(id, "Id cannot be null");
        return accountRepository.save(account);
    }

    public void delete(String id) {

    }

//    public Account pagination() {
//
    }
