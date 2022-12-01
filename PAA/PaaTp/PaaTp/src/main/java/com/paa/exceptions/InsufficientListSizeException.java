package com.paa.exceptions;

public class InsufficientListSizeException extends Exception {
    
    public InsufficientListSizeException() {}

    public InsufficientListSizeException(String message) {
        super(message);
    }
}