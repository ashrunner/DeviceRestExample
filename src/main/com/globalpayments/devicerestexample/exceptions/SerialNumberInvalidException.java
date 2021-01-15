package com.globalpayments.devicerestexample.exceptions;

public class SerialNumberInvalidException extends RuntimeException {
    public SerialNumberInvalidException(){
        super("ER003");
    }
}
