package com.globalpayments.devicerestexample.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Device {
    private String serialNumber;
    private String machineCode;
    private String name;
}
