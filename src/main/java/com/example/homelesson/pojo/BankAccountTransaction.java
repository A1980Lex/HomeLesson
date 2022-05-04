package com.example.homelesson.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * класс для данных о переводе между счетами
 * **/
@Getter
@Setter
public class BankAccountTransaction {

   /**
    * имя отправителя
    * **/
    String bankAccountSenderName;

    /**
     * имя получателя
     * **/
     String bankAccountRecipientName;

    /**
     * сумма перевода
     * **/
     Float amount;
}
