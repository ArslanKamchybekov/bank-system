package com.example.bank_system.service;

import com.example.bank_system.entity.Account;
import com.example.bank_system.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repository;

    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getAccount(Long accountNumber) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()) throw new RuntimeException("Account does not exist");
        return account.get();
    }

    @Override
    public List<Account> getAccounts() {
        return repository.findAll();
    }

    @Override
    public Account deposit(Long accountNumber, Double amount) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()) throw new RuntimeException("Account does not exist");
        double total = account.get().getBalance() + amount;
        account.get().setBalance(total);
        repository.save(account.get());
        return account.get();
    }

    @Override
    public Account withdraw(Long accountNumber, Double amount) {
        Optional<Account> account = repository.findById(accountNumber);
        if(account.isEmpty()) throw new RuntimeException("Account does not exist");
        if(account.get().getBalance() < amount) throw new RuntimeException("Amount should be less than balance");
        double total = account.get().getBalance() - amount;
        account.get().setBalance(total);
        repository.save(account.get());
        return account.get();
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccount(accountNumber);
        repository.deleteById(accountNumber);
    }
}
