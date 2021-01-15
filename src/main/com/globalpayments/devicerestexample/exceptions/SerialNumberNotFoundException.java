package com.globalpayments.devicerestexample.exceptions;

public class SerialNumberNotFoundException extends DatabaseCodeGeneratorException{

    public SerialNumberNotFoundException(){
        super("ER003");
    }
}
