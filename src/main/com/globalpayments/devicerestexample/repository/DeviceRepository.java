package com.globalpayments.devicerestexample.repository;

import com.globalpayments.devicerestexample.pojo.Device;

import java.util.List;

public interface DeviceRepository {
    List<Device> getByMachineCode(String machineCode);
    List<Device> getBySerialNumber(String serialNumber);
    List<Device> getByMachineCodeAndSerialNumber(String machineCode, String serialNumber);
    Device createDevice(Device device);
    Device updateDevice(Device device);
}
