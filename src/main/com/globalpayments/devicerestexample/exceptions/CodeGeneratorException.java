package com.globalpayments.devicerestexample.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeGeneratorException extends RuntimeException{
    private String code;
}
