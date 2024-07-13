package com.example.bank_system.service;

import com.example.bank_system.entity.Account;
import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);
    public Account getAccount(Long accountNumber);
    public List<Account> getAccounts();
    public Account deposit(Long accountNumber, Double amount);
    public Account withdraw(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
