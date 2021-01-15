package com.globalpayments.devicerestexample.exceptionhandler;

import com.globalpayments.devicerestexample.config.DeviceErrorCodes;
import com.globalpayments.devicerestexample.exceptions.CodeGeneratorException;
import com.globalpayments.devicerestexample.exceptions.CouldNotFindErrorCodeException;
import com.globalpayments.devicerestexample.exceptions.DatabaseCodeGeneratorException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class DeviceExceptionHandler extends ResponseEntityExceptionHandler {
    private final DeviceErrorCodes deviceErrorCodes;
    public DeviceExceptionHandler(DeviceErrorCodes deviceErrorCodes){
        this.deviceErrorCodes = deviceErrorCodes;
    }
    private List<DeviceError> getErrorCodes(String [] errorCodesToFind){
        List<DeviceError> errorsToReturn = new ArrayList<>();
        for(String errorCode : errorCodesToFind){
            errorsToReturn.add(
                    deviceErrorCodes.getPossibleErrorCodes().stream().filter(d -> d.getErrorCode().equals(errorCode)).findFirst()
                            .orElseThrow(CouldNotFindErrorCodeException::new)
            );
        }
        return errorsToReturn;
    }

    @ExceptionHandler(CodeGeneratorException.class)
    protected ResponseEntity<Object> handleMachineCodeNotFound(
            CodeGeneratorException ex) {
        String [] errorCodesToFind = ex.getCode().split(",");
        List<DeviceError> errorsToReturn = getErrorCodes(errorCodesToFind);
        return buildPreconditionFailedResponseEntity(errorsToReturn);
    }

    @ExceptionHandler(DatabaseCodeGeneratorException.class)
    protected ResponseEntity<Object> handleMachineCodeNotFound(
            DatabaseCodeGeneratorException ex) {
        String [] errorCodesToFind = ex.getCode().split(",");
        List<DeviceError> errorsToReturn = getErrorCodes(errorCodesToFind);
        return buildNotFoundResponseEntity(errorsToReturn);
    }
    private ResponseEntity<Object> buildPreconditionFailedResponseEntity(List<DeviceError> errors) {
        return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);

    }

    private ResponseEntity<Object> buildNotFoundResponseEntity(List<DeviceError> errors) {
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

}

