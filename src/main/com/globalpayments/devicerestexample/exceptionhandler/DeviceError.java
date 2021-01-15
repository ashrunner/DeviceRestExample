package com.globalpayments.devicerestexample.exceptionhandler;

import lombok.Data;

@Data
public class DeviceError {
    private String resourceKey;
    private String errorCode;
    private String message;
}
