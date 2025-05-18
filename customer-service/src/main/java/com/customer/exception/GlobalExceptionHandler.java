package com.customer.exception;

import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.crypto.agreement.ECDHCStagedAgreement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail("Customer is not found.");
        problemDetail.setStatus(HttpStatus.NOT_FOUND);
        problemDetail.setDetail(customerNotFoundException.getMessage());
        problemDetail.setProperty("timestamp", Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(CustomerAlreadyAvailableException.class)
    public ResponseEntity<ProblemDetail> handleCustomerAlreadyAvailableException(CustomerAlreadyAvailableException customerAlreadyAvailableException){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setDetail("Customer is already available with email id.");
        problemDetail.setStatus(HttpStatus.CONFLICT);
        problemDetail.setDetail(customerAlreadyAvailableException.getMessage());
        problemDetail.setProperty("timestamp", Instant.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGenericException(Exception exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail("Something went wrong - INTERNAL_SERVER_ERROR");
        problemDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setProperty("timestamp", Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
    }
}
