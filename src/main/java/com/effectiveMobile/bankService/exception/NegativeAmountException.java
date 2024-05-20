package com.effectiveMobile.bankService.exception;

public class NegativeAmountException extends RuntimeException{
    public NegativeAmountException(String message) {
        super(message);
    }
}
