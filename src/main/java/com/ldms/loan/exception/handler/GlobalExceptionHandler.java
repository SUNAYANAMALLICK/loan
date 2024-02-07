package com.ldms.loan.exception.handler;

import com.ldms.loan.exception.InvalidLoanException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanException.class)
    public ResponseEntity<String> handleCustomerValidationException(InvalidLoanException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>("Validation Error: " + errorMessage, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
