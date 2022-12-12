package com.shelzi.solvdlaba.hm2_oop.banksystem.exception;

public class MaxCurrencyValueOverflowException extends ServiceException{
    public MaxCurrencyValueOverflowException(Throwable cause) {
        super(cause);
    }

    public MaxCurrencyValueOverflowException(String message) {
        super(message);
    }
}