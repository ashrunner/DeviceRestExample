package com.globalpayments.devicerestexample.exceptions;

public class MachineCodeNotFoundException extends DatabaseCodeGeneratorException {
    public MachineCodeNotFoundException(){
        super("ER002");
    }
}
