package com.globalpayments.devicerestexample.exceptions;

public class MachineCodeAndSerialNumberNotFoundException extends DatabaseCodeGeneratorException{

    public MachineCodeAndSerialNumberNotFoundException(){
        super("ER002,ER004");
    }
}
