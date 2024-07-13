package com.example.bank_system.controller;

import com.example.bank_system.entity.Account;
import com.example.bank_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountNumber){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccount(accountNumber));
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccounts());
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account deposit(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.deposit(accountNumber, amount);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdraw(@PathVariable Long accountNumber, @PathVariable Double amount){
        return service.withdraw(accountNumber, amount);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
        return ResponseEntity.status(HttpStatus.OK).body("Account closed");
    }
}
