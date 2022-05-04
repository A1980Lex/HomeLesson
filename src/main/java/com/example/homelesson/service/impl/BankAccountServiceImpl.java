package com.example.homelesson.service.impl;

import com.example.homelesson.entity.BankAccount;
import com.example.homelesson.exception.BadRequestException;
import com.example.homelesson.pojo.BankAccountChange;
import com.example.homelesson.pojo.BankAccountTransaction;
import com.example.homelesson.repositories.BankAccountRepository;
import com.example.homelesson.service.BankAccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    /**
    * создает аккаунт в БД
    * **/
    @Override
    public void createBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    /**
     * пополнение баланса
     * **/
    @Override
    @Transactional
    public BankAccount addMoneyToBankAccount(BankAccountChange bankAccountChange) {

        BankAccount accountToChange = bankAccountRepository.findByAccountHolderName(bankAccountChange.getBankAccountHolderName());
        Float balance = accountToChange.getAccountBalance();
        Float amountOfChange = bankAccountChange.getAmountOfChange();
        Float newBalance = balance + amountOfChange;
        accountToChange.setAccountBalance(newBalance);
        return bankAccountRepository.save(accountToChange);
    }

    /**
     * снятие со счета
     * **/
    @Override
    @Transactional
    public BankAccount getMoneyFromBankAccount(BankAccountChange bankAccountChange) {
        BankAccount accountToChange = bankAccountRepository.findByAccountHolderName(bankAccountChange.getBankAccountHolderName());
        Float balance = accountToChange.getAccountBalance();
        Float amountOfChange = bankAccountChange.getAmountOfChange();
        Float newBalance = balance - amountOfChange;
        if (newBalance < 0){
            throw new BadRequestException();
        }
        accountToChange.setAccountBalance(newBalance);
        return bankAccountRepository.save(accountToChange);
    }

    /**
     * перевод между счетами
     * **/
    @Override
    @Transactional
    public List<BankAccount> transferMoneyBetweenAccounts(BankAccountTransaction bankAccountTransaction) {

        BankAccount sender = bankAccountRepository.findByAccountHolderName(bankAccountTransaction.getBankAccountSenderName());
        BankAccount recipient = bankAccountRepository.findByAccountHolderName(bankAccountTransaction.getBankAccountRecipientName());

        Float amountOfOperation = bankAccountTransaction.getAmount();

        Float senderBalance = sender.getAccountBalance();
        Float recipientBalance = recipient.getAccountBalance();

        senderBalance = senderBalance - amountOfOperation;

        if (senderBalance < 0){
            throw new BadRequestException();
        }

        recipientBalance = recipientBalance + amountOfOperation;

        sender.setAccountBalance(senderBalance);
        recipient.setAccountBalance(recipientBalance);

        bankAccountRepository.save(sender);
        bankAccountRepository.save(recipient);

        return bankAccountRepository.findAll();
    }
}
