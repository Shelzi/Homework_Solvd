package com.shelzi.solvdlaba.hm2_oop.daohw.exception;

public class ServiceException extends Exception {
    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message) {
        super(message);
    }
}