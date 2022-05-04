package com.example.homelesson.controller;

import com.example.homelesson.entity.BankAccount;
import com.example.homelesson.pojo.BankAccountChange;
import com.example.homelesson.pojo.BankAccountTransaction;
import com.example.homelesson.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final BankAccountService bankAccountService;

    public AccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    /**
     * метод для пополнения баланса
     * **/
    @PutMapping("/account/put")
    public ResponseEntity<BankAccount> putMoney(@RequestBody BankAccountChange bankAccountChange){
        BankAccount operationResult = bankAccountService.addMoneyToBankAccount(bankAccountChange);
        return new ResponseEntity<>(operationResult, HttpStatus.OK);
    }

    /**
     * метод для списания денег с баланса
     * **/
    @PutMapping("/account/get")
    public ResponseEntity<BankAccount> getMoney(@RequestBody BankAccountChange bankAccountChange){
        BankAccount operationResult = bankAccountService.getMoneyFromBankAccount(bankAccountChange);
        return new ResponseEntity<>(operationResult, HttpStatus.OK);
    }

    /**
     * метод для перевода между счетами
     * **/
    @PutMapping("/account/transfer")
    public ResponseEntity<List<BankAccount>> transferMoney(@RequestBody BankAccountTransaction bankAccountTransaction){
        List<BankAccount> operationResult = bankAccountService.transferMoneyBetweenAccounts(bankAccountTransaction);
        return new ResponseEntity<>(operationResult, HttpStatus.OK);
    }
}
