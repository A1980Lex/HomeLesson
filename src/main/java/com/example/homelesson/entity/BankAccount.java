package com.example.homelesson.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * сущность банковский аккаунт
 * **/
@Entity
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Table(name = "BANK_ACCOUNT")
public class BankAccount {

    /**
     * уникальный идентификатор
     * **/
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * имя владельца аккаунта
     * **/
    @Column(name = "ACCOUNT_HOLDER", nullable = false)
    private String accountHolderName;

    /**
     * баланс аккаунта
     * **/
    @Column(name = "ACCOUNT_BALANCE", nullable = false)
    private Float accountBalance;

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
