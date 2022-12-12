package com.shelzi.solvdlaba.hm2_oop.banksystem.exception;

public class NoRequiredCurrencyTypeException extends ServiceException{
    public NoRequiredCurrencyTypeException(Throwable cause) {
        super(cause);
    }

    public NoRequiredCurrencyTypeException(String message) {
        super(message);
    }
}