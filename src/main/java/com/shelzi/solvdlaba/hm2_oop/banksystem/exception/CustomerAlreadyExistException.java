package com.shelzi.solvdlaba.hm2_oop.banksystem.exception;

public class CustomerAlreadyExistException extends ServiceException{
    public CustomerAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}