package com.globalpayments.devicerestexample.config;

import com.globalpayments.devicerestexample.exceptionhandler.DeviceError;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix="error-codes")
public class DeviceErrorCodes {
    private List<DeviceError> possibleErrorCodes;

    public List<DeviceError> getPossibleErrorCodes() {
        return possibleErrorCodes;
    }
}
