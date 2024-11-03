package com.app.customException;





import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CabNotAvailableException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCabNotAvailable(CabNotAvailableException e) {
        return e.getMessage();
    }
}

