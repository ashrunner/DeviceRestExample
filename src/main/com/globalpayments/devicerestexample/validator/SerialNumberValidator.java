package com.globalpayments.devicerestexample.validator;

import java.util.regex.Pattern;

public class SerialNumberValidator implements Validator {

    @Override
    public boolean isValid(String serialNumber) {
        return serialNumber.matches("^[A-Za-z0-9]+-[A-Za-z0-9]+$");
    }
}
