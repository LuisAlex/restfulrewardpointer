package com.kforce.charter.restfulrewardpointer.exception;

public class NumberFormatException extends RuntimeException {
    public NumberFormatException(String message) {
        super("Value is not an Integer");
    }
}
