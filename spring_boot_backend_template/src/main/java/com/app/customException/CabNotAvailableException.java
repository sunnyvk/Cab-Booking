package com.app.customException;



public class CabNotAvailableException extends RuntimeException {
    public CabNotAvailableException(String message) {
        super(message);
    }
}

