package com.globalpayments.devicerestexample.validator;

public class MachineCodeValidator implements Validator{

    @Override
    public boolean isValid(String machineCode) {
        return machineCode.isBlank();
    }
}
