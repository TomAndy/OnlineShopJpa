package com.mp.onlinestore.exceptions;

import java.util.Set;

public class ValidationException extends Exception {

    private final Set<String> errorCodes;

    public ValidationException(Set<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public Set<String> getErrorCodes() {
        return errorCodes;
    }
}
