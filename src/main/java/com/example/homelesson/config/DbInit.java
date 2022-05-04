package com.example.homelesson.config;

import com.example.homelesson.entity.BankAccount;
import com.example.homelesson.pojo.BankAccountChange;
import com.example.homelesson.service.BankAccountService;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;


@Configuration
public class DbInit {

    private final BankAccountService bankAccountService;

    public DbInit(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostConstruct
    public void createBankAccount(){

        BankAccount account1 = BankAccount.builder().accountHolderName("Aleksandr").accountBalance(100f).build();
        BankAccount account2 = BankAccount.builder().accountHolderName("Petr").accountBalance(200f).build();

        bankAccountService.createBankAccount(account1);
        bankAccountService.createBankAccount(account2);

    }
}
