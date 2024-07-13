package com.example.bank_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_number;
    @Column
    private String account_holder_name;
    @Column
    private double balance;

    public Account() {}

    public Account(String account_holder_name, double balance) {
        this.account_holder_name = account_holder_name;
        this.balance = balance;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
