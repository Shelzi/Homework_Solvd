package com.shelzi.solvdlaba.hm2_oop.banksystem.exception;

public class NoSuchCustomerExistException extends ServiceException {
    public NoSuchCustomerExistException(Throwable cause) {
        super(cause);
    }

    public NoSuchCustomerExistException(String message) {
        super(message);
    }
}