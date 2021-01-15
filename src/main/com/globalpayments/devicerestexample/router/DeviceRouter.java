package com.globalpayments.devicerestexample.router;

import com.globalpayments.devicerestexample.exceptions.MachineCodeInvalidException;
import com.globalpayments.devicerestexample.exceptions.NoDeviceSearchParameterException;
import com.globalpayments.devicerestexample.exceptions.SerialNumberInvalidException;
import com.globalpayments.devicerestexample.pojo.Device;
import com.globalpayments.devicerestexample.repository.DeviceRepository;
import com.globalpayments.devicerestexample.validator.MachineCodeValidator;
import com.globalpayments.devicerestexample.validator.SerialNumberValidator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Device")
public class DeviceRouter {
    private DeviceRepository deviceRepository;
    private MachineCodeValidator machineCodeValidator;
    private SerialNumberValidator serialNumberValidator;
    public DeviceRouter(DeviceRepository deviceRepository,
                        MachineCodeValidator machineCodeValidator, SerialNumberValidator serialNumberValidator){
        this.deviceRepository = deviceRepository;
        this.machineCodeValidator = machineCodeValidator;
        this.serialNumberValidator = serialNumberValidator;
    }

    private void checkSerialNumber(String serialNumber){
        if(!serialNumberValidator.isValid(serialNumber)){
            throw new SerialNumberInvalidException();
        }
    }

    private void checkMachineCode(String machineCode){
        if(!machineCodeValidator.isValid(machineCode)){
            throw new MachineCodeInvalidException();
        }
    }

    @GetMapping()
    public List<Device> getDevice(@RequestParam(name = "serialNumber") String serialNumber,
                                  @RequestParam(name = "machineCode") String machineCode){
        if(machineCode != null ){
            checkMachineCode(machineCode);
            if(serialNumber != null){
                checkSerialNumber(serialNumber);
                return deviceRepository.getByMachineCodeAndSerialNumber(machineCode,serialNumber);
            } else{
                return deviceRepository.getByMachineCode(serialNumber);
            }
        } else{
            if(serialNumber == null) {
                throw new NoDeviceSearchParameterException();
            }
            checkSerialNumber(serialNumber);
            return deviceRepository.getBySerialNumber(serialNumber);
        }

    }

    @PostMapping()
    public Device createDevice(Device device){
        return deviceRepository.createDevice(device);
    }

    @PutMapping()
    public Device updateDevice(Device device){
        return deviceRepository.updateDevice(device);
    }
}
