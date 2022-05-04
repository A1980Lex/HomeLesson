package com.example.homelesson.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * класс для данных о операции
 * **/
@Getter
@Setter
public class BankAccountChange {

    /**
     * имя владельца банковского аккаунта
     * **/
    String bankAccountHolderName;

    /**
     * сумма операции
     * **/
    Float amountOfChange;
}
