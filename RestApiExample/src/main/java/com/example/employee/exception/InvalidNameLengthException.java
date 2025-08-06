package com.example.employee.exception;

public class InvalidNameLengthException extends RuntimeException{
    public InvalidNameLengthException(String message) {
        super(message);
    }

}
