package com.mp.onlinestore.util;

import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.exceptions.ValidationException;
import com.mp.onlinestore.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomExceptionHandler {


    @Autowired
    private ResponseMessages responseMessages;

    public void printValidationExceptions(ValidationException ve) {
        for(String err: ve.getErrorCodes()) {
            System.out.println(err);
        }
    }


    public GeneralResponse handleErrorResponse(Exception exception) {

        GeneralResponse generalResponse = new GeneralResponse();

        Set<String> errorMessages = new HashSet<>();
        if(exception instanceof ValidationException) {
            ValidationException validationException = (ValidationException) exception;
            for(String errorCode: validationException.getErrorCodes()) {
                errorMessages.add(responseMessages.getMessage(errorCode));
            }
        } else {
          errorMessages.add(responseMessages.getMessage(ErrorCodes.GEN_ERR));
        }

        generalResponse.setSuccessMessage(errorMessages.toString());
        return  generalResponse;

    }

}
