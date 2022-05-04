package com.example.homelesson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ResponseStatusException {

    public BadRequestException(){super(HttpStatus.BAD_REQUEST, "Сумма платежа не может быть больше остатка по счету");}
}
