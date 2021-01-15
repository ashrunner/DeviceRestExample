package com.globalpayments.devicerestexample.repository;

import com.globalpayments.devicerestexample.pojo.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepositoryStub implements DeviceRepository {
    @Override
    public List<Device> getByMachineCode(String machineCode) {
        return new ArrayList<>();
    }

    @Override
    public List<Device> getBySerialNumber(String serialNumber) {
        return new ArrayList<>();
    }

    @Override
    public List<Device> getByMachineCodeAndSerialNumber(String machineCode, String serialNumber) {
        return new ArrayList<>();
    }

    @Override
    public Device createDevice(Device device) {
        return device;
    }

    @Override
    public Device updateDevice(Device device) {
        return device;
    }
}
