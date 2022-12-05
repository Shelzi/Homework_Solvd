package main.java.com.shelzi.solvdlaba.hm2_oop.banksystem.exception;

public class NotEnoughMoneyException extends ServiceException{
    public NotEnoughMoneyException(Throwable cause) {
        super(cause);
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}