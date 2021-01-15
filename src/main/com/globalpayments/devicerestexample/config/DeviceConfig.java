package com.globalpayments.devicerestexample.config;

import com.globalpayments.devicerestexample.repository.DeviceRepository;
import com.globalpayments.devicerestexample.repository.DeviceRepositoryStub;
import com.globalpayments.devicerestexample.validator.MachineCodeValidator;
import com.globalpayments.devicerestexample.validator.SerialNumberValidator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DeviceErrorCodes.class)
public class DeviceConfig {
    @Bean
    public MachineCodeValidator machineCodeValidator(){
        return new MachineCodeValidator();
    }

    @Bean
    public SerialNumberValidator serialNumberValidator(){
        return new SerialNumberValidator();
    }

    @Bean
    public DeviceRepository deviceRepository(){
        return new DeviceRepositoryStub();
    }

    @Bean
    public DeviceErrorCodes deviceErrorCodes(){
        return new DeviceErrorCodes();
    }
}
