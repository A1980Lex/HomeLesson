package com.example.homelesson.service;

import com.example.homelesson.entity.BankAccount;
import com.example.homelesson.pojo.BankAccountChange;
import com.example.homelesson.pojo.BankAccountTransaction;

import java.util.List;

public interface BankAccountService {

    void createBankAccount(BankAccount bankAccount);

    BankAccount addMoneyToBankAccount(BankAccountChange bankAccountChange);

    BankAccount getMoneyFromBankAccount(BankAccountChange bankAccountChange);

    List<BankAccount> transferMoneyBetweenAccounts(BankAccountTransaction bankAccountTransaction);
}
