package com.example.myinteractivecv.exception;

public abstract class UserException extends RuntimeException{
    public UserException(String msg) {
        super(msg);
    }
}
