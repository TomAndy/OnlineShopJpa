package com.mp.onlinestore.Exceptions;

import com.mp.onlinestore.consts.ErrorCodes;

public class GenericException extends Exception {

    public String getErrorCode() {
        return errorCode;
    }

    private final String errorCode;

    public GenericException() {
        super();
        errorCode = ErrorCodes.GEN_ERR;
    }

    public GenericException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
